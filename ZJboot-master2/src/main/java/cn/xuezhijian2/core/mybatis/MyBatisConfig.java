//package cn.xuezhijian2.core.mybatis;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//
//import com.github.pagehelper.PageHelper;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * Created with IntelliJ IDEA.
// * packageName  : cn.xuezhijian2.core.mybatis
// * User         : zj
// * Date         : 17/4/15
// * Time         : 下午2:43
// * Description  :
// */
//
//@Configuration
//public class MyBatisConfig {
//
//    @Value("${spring.datasource.readSize}")
//    private String dataSourceSize;
//
//    @Resource(name = "primaryDataSource")
//    private DataSource primaryDataSource;
//
//    @Resource(name = "auxiliaryDataSource")
//    private DataSource auxiliaryDataSource;
//
//
//    private DataSource getPrimaryDataSource(){
//        return primaryDataSource;
//    }
//
//    private DataSource getAuxiliaryDataSource(){
//        return auxiliaryDataSource;
//    }
//
//    /**
//     * AbstractRoutingDataSource 这破玩意 继承了AbstractDataSource ,AbstractDataSource又实现了DataSource
//     * 所以可以直接丢去构建 SqlSessionFactory
//     * @return
//     */
//    @Bean
//    public AbstractRoutingDataSource dataSourceProxy(){
//        int size = Integer.parseInt(dataSourceSize);
//        MyRoutingDataSource proxy = new MyRoutingDataSource(size);
//        Map<Object,Object> dataSourceMap = new HashMap<>();
//        DataSource primarySource = getPrimaryDataSource();
//        DataSource auxiliarySource = getAuxiliaryDataSource();
//
//        dataSourceMap.put(TargetDataSource.PRIMARY.getCode(),primarySource);
//        dataSourceMap.put(TargetDataSource.AUXILIARY.getCode(),auxiliarySource);
//
//        proxy.setDefaultTargetDataSource(primarySource);
//        proxy.setTargetDataSources(dataSourceMap);
//        return proxy;
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactorys() {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy());
//        bean.setTypeAliasesPackage("cn.xuezhijian2");
//
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        //添加插件
//        bean.setPlugins(new Interceptor[]{pageHelper});
//
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            bean.setMapperLocations(resolver.getResources("classpath:**/mapper/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//
//
//
//
//
//
//
//}
