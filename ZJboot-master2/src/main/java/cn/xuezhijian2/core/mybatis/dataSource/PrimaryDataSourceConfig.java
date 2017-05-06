package cn.xuezhijian2.core.mybatis.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
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
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.mybatis.dataSource
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午4:10
 * Description  :
 */

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@MapperScan(basePackages = "cn.xuezhijian2.demo.test.primary.mapper", sqlSessionTemplateRef = "primarySqlSessionTemplate")//可以用*或者**模糊匹配
public class PrimaryDataSourceConfig {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Autowired
    private DruidProperties properties;

    //主数据源
    @Bean(value = "primaryDataSource")
    @ConfigurationProperties(prefix = "datasource.primary")
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder.create().type(dataSourceType).build();
        return DruidSettingUtil.setupDataSource(dataSource,properties);
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("cn.xuezhijian2");

        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});

        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:**/primary/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
