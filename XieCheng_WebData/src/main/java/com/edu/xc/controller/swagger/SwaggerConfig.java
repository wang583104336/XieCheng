package com.edu.xc.controller.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //整个接口网页的基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact("laowang", "http://1000phone.com", "583104336@qq.com");
        return new ApiInfoBuilder().version("1.1.0").contact(contact).title("钱多多数据接口在线文档").description("for more money").build();
    }

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

}
