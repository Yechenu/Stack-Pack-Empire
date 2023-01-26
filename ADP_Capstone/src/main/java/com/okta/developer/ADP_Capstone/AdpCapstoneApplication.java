package com.okta.developer.ADP_Capstone;

import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import com.okta.developer.ADP_Capstone.FormI9.Section1.repository.Section1_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdpCapstoneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdpCapstoneApplication.class, args);
	}
	@Autowired
	private Section1_Repository section1_repository;
	@Override
	public void run(String... args) throws Exception {

		this.section1_repository.save(new Section1("Code", "Gem", "R", "none", "123 address",
				123, "Atlanta", "Georgia","30039", "September 2, 1990","","gc@gmail.com",
				"404-324-1065",1,"00-00-0000",1,1,"signatureBlob",
				"nul","","","","",""));

	}
}
