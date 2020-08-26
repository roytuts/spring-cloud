package com.roytuts.spring.fahrenheit.to.celsius.converter;

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
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class })
public class FahrenheitToCelsiusConverterApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(FahrenheitToCelsiusConverterApp.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(FahrenheitToCelsiusConverterApp.class, args);
	}

	@GetMapping("/fahrenheit/{f}/to/celsius/")
	public ResponseEntity<Float> convertFahrenheitToCelsius(@PathVariable("f") float fahrenheit) {
		float c = (float) ((fahrenheit - 32) / 1.8);

		LOGGER.info("Fahrenheit to Celsius: {} -> {}", fahrenheit, c);

		return new ResponseEntity<Float>(c, HttpStatus.OK);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/call/celsius/{c}/to/fahrenheit/")
	public ResponseEntity<Float> callCelsiusToFahrenheit(@PathVariable("c") float celsius) {
		LOGGER.info("callCelsiusToFahrenheit()");

		return restTemplate().getForEntity("http://localhost:8000/celsius/" + celsius + "/to/fahrenheit/", Float.class);
	}

}
