package com.roytuts.spring.celsius.to.fahrenheit.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@RestController
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class })
public class CelsiusToFahrenheitConverterApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(CelsiusToFahrenheitConverterApp.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(CelsiusToFahrenheitConverterApp.class, args);
	}

	@GetMapping("/celsius/{c}/to/fahrenheit/")
	public ResponseEntity<Float> convertCelsiusToFahrenheit(@PathVariable("c") float celsius) {
		float f = (float) (32 + 1.8 * celsius);

		LOGGER.info("Celsius to Fahrenheit: {} -> {}", celsius, f);

		return new ResponseEntity<Float>(f, HttpStatus.OK);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
