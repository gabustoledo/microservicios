package com.arquitectura.importarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImportarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImportarServiceApplication.class, args);
	}

}
