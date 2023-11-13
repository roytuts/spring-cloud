package com.roytuts.cc.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import reactor.core.publisher.Flux;

public class ForexConfiguration {

	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new ForexServiceInstanceListSuppler("forex-service");
	}

}

class ForexServiceInstanceListSuppler implements ServiceInstanceListSupplier {

	private final String serviceId;

	ForexServiceInstanceListSuppler(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 9000, false),
				new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 9001, false)));
	}

}
