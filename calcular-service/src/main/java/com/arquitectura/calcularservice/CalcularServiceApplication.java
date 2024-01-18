package com.arquitectura.calcularservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalcularServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcularServiceApplication.class, args);
	}

}
