package com.motoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MotoServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server-port", "8003");
		SpringApplication.run(MotoServiceApplication.class, args);
	}

}
