package com.roytuts.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApp.class, args);
	}

}
