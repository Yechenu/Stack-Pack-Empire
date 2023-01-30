package com.okta.developer.ADP_Capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdpCapstoneApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AdpCapstoneApplication.class, args);
	}

}
