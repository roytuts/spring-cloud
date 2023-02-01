package com.roytuts.spring.boot.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApp.class, args);
	}

}
