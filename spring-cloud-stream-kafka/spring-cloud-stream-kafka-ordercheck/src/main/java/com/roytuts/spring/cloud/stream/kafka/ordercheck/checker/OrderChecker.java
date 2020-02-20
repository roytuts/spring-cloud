package com.roytuts.spring.cloud.stream.kafka.ordercheck.checker;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.roytuts.spring.cloud.stream.kafka.ordercheck.enums.Status;
import com.roytuts.spring.cloud.stream.kafka.ordercheck.model.Order;
import com.roytuts.spring.cloud.stream.kafka.ordercheck.processor.OrderProcessor;

@Component
public class OrderChecker {

	public static final Logger LOG = LoggerFactory.getLogger(OrderChecker.class);

	private static final List<String> DISCARDED_ITEMS = Arrays.asList("Watch", "Clock");

	@Autowired
	private OrderProcessor processor;

	@StreamListener(OrderProcessor.ORDERS_IN)
	public void checkAndSortOrders(Order order) {
		LOG.info("{} {} for {} for {}", order.getStatus(), order.getUuid(), order.getItem(), order.getName());

		if (DISCARDED_ITEMS.contains(order.getItem())) {
			order.setStatus(Status.UNDELIVERED.name());
			processor.undelivered().send(message(order));
		} else {
			order.setStatus(Status.DELIVERED.name());
			processor.delivered().send(message(order));
		}

		LOG.info("{} {} for {} for {}", order.getStatus(), order.getUuid(), order.getItem(), order.getName());
	}

	private static final <T> Message<T> message(T val) {
		return MessageBuilder.withPayload(val).build();
	}

}
