package com.assignment.AtdSpringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.assignment.AtdSpringproject.controller")
@EnableJpaRepositories(basePackages = "com.assignment.AtdSpringproject.repository")
public class AtdSpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtdSpringprojectApplication.class, args);
	}

}
