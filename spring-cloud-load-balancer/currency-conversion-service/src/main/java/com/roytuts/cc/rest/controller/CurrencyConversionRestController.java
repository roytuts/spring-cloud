package com.roytuts.cc.rest.controller;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.roytuts.cc.model.CurrencyConversion;

import reactor.core.publisher.Mono;

@RestController
public class CurrencyConversionRestController {

	private final WebClient.Builder loadBalancedWebClientBuilder;
	private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public CurrencyConversionRestController(WebClient.Builder webClientBuilder,
			ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		this.loadBalancedWebClientBuilder = webClientBuilder;
		this.lbFunction = lbFunction;
	}

	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public Mono<CurrencyConversion> getCurrencyExchange(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {

		Mono<CurrencyConversion> response = WebClient.builder().filter(lbFunction).build().get()
				// Mono<CurrencyConversion> response =
				// loadBalancedWebClientBuilder.build().get()
				.uri("http://forex-service/forex-exchange/from/{from}/to/{to}", from, to).retrieve()
				.bodyToMono(CurrencyConversion.class)
				.map(r -> new CurrencyConversion(quantity, from, to, r.getRate(), quantity, quantity * r.getRate()));

		return response;
	}

}
