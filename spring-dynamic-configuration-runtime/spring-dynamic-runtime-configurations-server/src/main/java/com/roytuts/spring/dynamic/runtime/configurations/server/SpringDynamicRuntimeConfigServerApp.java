package com.roytuts.spring.dynamic.runtime.configurations.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringDynamicRuntimeConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringDynamicRuntimeConfigServerApp.class, args);
	}

}
