package com.aosica.lot.config;

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
*  智慧农业在线文档。Swagger2 的配置。
* @Description:
* @author zp
* @email zp152527@163.com
* @date 2018/8/9 13:49 
*
*/
@Configuration
@EnableSwagger2
//@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aosica.lot.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("aosica-lot 物联网 api 文档")
                .description("aosica-lot 物联网 api 文档")
                //.termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}