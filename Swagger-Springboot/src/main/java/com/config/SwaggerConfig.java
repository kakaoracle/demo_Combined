package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户")
                .select()
                // 指定api所在的路径
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build()
                .apiInfo(applicationInfo());
    }

    /*swagger页面显示的内容*/
    private ApiInfo applicationInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建的RESTFUL 文档")//一级标题
                .description("此API提供接口调用")//标题下的小字说明
                .version("1.0")
                .termsOfServiceUrl("http://localhost:8080/")//代表ui界面的实际地址是http://localhost:8080/swagger-ui.html
                .build();
    }

}
