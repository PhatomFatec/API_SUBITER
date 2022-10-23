package com.example.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("test")
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(Arrays.asList(apiKey()));
	}

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("REST API Document - Subiter")
	            .description("work in progress")
	            .termsOfServiceUrl("localhost (por enquanto)")
	            .version("1.0")
	            .build();
	}

	private ApiKey apiKey() {
	    return new ApiKey("Bearer", "Authorization", "header");
	}
}
