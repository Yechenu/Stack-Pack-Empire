package com.okta.developer.ADP_Capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing // this will help in writing create_at and update_at dates.
@EnableSwagger2
public class AdpCapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdpCapstoneApplication.class, args);
	}
	
	
	//Swagger searches all the controllers and prepares a UI presentation 
	//with all the API documentation that one can use in Postman
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.okta.developer.ADP_Capstone")).build();
	}
	
}
