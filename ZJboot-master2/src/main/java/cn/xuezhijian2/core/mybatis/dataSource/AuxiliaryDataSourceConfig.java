package cn.xuezhijian2.core.mybatis.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.mybatis.dataSource
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午4:14
 * Description  :
 */

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@MapperScan(basePackages = "cn.xuezhijian2.demo.test.auxiliary.mapper", sqlSessionTemplateRef = "auxiliarySqlSessionTemplate")//可以用*或者**模糊匹配
public class AuxiliaryDataSourceConfig {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Autowired
    private DruidProperties properties;

    //次数据源
    @Bean(name = "auxiliaryDataSource")
    @ConfigurationProperties(prefix = "datasource.auxiliary")
    public DataSource auxiliaryDataSource() {
        DruidDataSource dataSource = (DruidDataSource)DataSourceBuilder.create().type(dataSourceType).build();
        return DruidSettingUtil.setupDataSource(dataSource,properties);
    }

    @Bean(name = "auxiliarySqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("auxiliaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("cn.xuezhijian2");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:**/auxiliary/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "auxiliaryTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("auxiliaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "auxiliarySqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("auxiliarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
