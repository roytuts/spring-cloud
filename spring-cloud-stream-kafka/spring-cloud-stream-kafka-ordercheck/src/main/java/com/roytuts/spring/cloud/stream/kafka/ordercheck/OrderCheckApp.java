package com.roytuts.spring.cloud.stream.kafka.ordercheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.roytuts.spring.cloud.stream.kafka.ordercheck.processor.OrderProcessor;

@SpringBootApplication
@EnableBinding(OrderProcessor.class)
public class OrderCheckApp {

	public static final Logger LOG = LoggerFactory.getLogger(OrderCheckApp.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderCheckApp.class, args);

		LOG.info("The Order Check Application has started...");
	}

}
