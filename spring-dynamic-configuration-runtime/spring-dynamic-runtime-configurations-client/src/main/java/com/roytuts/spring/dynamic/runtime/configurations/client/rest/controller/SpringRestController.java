package com.roytuts.spring.dynamic.runtime.configurations.client.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SpringRestController {

	@Value("${msg:Hey}")
	private String msg;

	@GetMapping("/msg")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
