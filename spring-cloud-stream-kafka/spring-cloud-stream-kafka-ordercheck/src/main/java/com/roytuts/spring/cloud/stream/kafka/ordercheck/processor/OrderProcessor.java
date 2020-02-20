package com.roytuts.spring.cloud.stream.kafka.ordercheck.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface OrderProcessor {

	String ORDERS_IN = "output";
	String DELIVERED_OUT = "delivered";
	String UNDELIVERED_OUT = "undelivered";

	@Input(ORDERS_IN)
	SubscribableChannel sourceOfOrders();

	@Output(DELIVERED_OUT)
	MessageChannel delivered();

	@Output(UNDELIVERED_OUT)
	MessageChannel undelivered();

}
