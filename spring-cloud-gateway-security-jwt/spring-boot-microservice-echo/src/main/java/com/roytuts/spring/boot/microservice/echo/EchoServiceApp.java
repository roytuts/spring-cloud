package com.roytuts.spring.boot.microservice.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EchoServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(EchoServiceApp.class, args);
	}

	@GetMapping("/echo/{msg}")
	public ResponseEntity<String> echo(@PathVariable String msg) {
		return new ResponseEntity<String>("Your message, " + msg, HttpStatus.OK);
	}

}
