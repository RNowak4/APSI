package com.apsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.apsi.domain.repositories")
public class ApsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsiApplication.class, args);
	}
}
