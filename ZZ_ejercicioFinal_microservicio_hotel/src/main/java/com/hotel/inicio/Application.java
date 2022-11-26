package com.hotel.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.hotel.model")
@EnableJpaRepositories(basePackages = "com.hotel.dao")
@SpringBootApplication(scanBasePackages = {"com.hotel.controller","com.hotel.service","com.hotel.inicio"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
