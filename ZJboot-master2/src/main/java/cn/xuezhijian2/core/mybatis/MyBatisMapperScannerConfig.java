//package cn.xuezhijian2.core.mybatis;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tk.mybatis.mapper.common.Mapper;
//import tk.mybatis.spring.mapper.MapperScannerConfigurer;
//
//import java.util.Properties;
//
///**
// * Created with IntelliJ IDEA.
// * packageName  : cn.xuezhijian2.core.mybatis
// * User         : zj
// * Date         : 17/4/16
// * Time         : 上午1:22
// * Description  :
// */
//
//@Configuration
////TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
//@AutoConfigureAfter(MyBatisConfig.class)
//public class MyBatisMapperScannerConfig {
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        //这里的BasePackage 不能写com.xuezijian,估计跟spring 的扫描冲突,会实例化两个service,应该需要重构目录
//        mapperScannerConfigurer.setBasePackage("cn.xuezhijian2.*.mapper");
//        Properties properties = new Properties();
//        properties.setProperty("mappers", Mapper.class.getName());
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        mapperScannerConfigurer.setProperties(properties);
//        return mapperScannerConfigurer;
//    }
//
//}
