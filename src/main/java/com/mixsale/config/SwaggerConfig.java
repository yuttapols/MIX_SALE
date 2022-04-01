package com.mixsale.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Value("${application.name}")
//    private String applicationName;
//
//    @Value("${build.version}")
//    private String buildVersion;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.version("1.0")
						.title("MixSaleProject")
						.description("").build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mixsale.controller"))
				.paths(PathSelectors.any()).build();
		
		
	}
}
