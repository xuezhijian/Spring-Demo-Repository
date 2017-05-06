package cn.xuezhijian2.core.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.api
 * User         : zj
 * Date         : 17/4/16
 * Time         : 下午2:17
 * Description  :
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.xuezhijian2"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ZJBoot中使用Swagger2构建RESTful APIs")
                .description("demo项目")
                .termsOfServiceUrl("https://www.baidu.com/")
                .contact("XueZhiJian")
                .version("1.0")
                .build();
    }

}
