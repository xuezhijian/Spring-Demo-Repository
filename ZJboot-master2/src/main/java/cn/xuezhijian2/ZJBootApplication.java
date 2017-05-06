package cn.xuezhijian2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2
 * User         : zj
 * Date         : 17/4/15
 * Time         : 下午2:21
 * Description  :
 */

//extends SpringBootServletInitializer

@EnableRabbit
@EnableAsync
@EnableScheduling
@EnableTransactionManagement// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class ZJBootApplication {

    // jar启动
    public static void main(String[] args) throws InterruptedException{
        SpringApplication.run(ZJBootApplication.class, args);
    }

//    // tomcat war启动
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(ZJBootApplication.class);
//    }

}
