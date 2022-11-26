package com.reservas.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.reservas.model")
@EnableJpaRepositories(basePackages = "com.reservas.dao")
@SpringBootApplication(scanBasePackages = {"com.reservas.controller","com.reservas.service","com.reservas.inicio"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		BasicAuthenticationInterceptor intercep;
		intercep = new BasicAuthenticationInterceptor("user3", "user3");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(intercep);
		return restTemplate;
	}
}
