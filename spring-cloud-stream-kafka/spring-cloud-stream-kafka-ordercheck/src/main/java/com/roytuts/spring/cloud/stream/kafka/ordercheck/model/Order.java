package com.roytuts.spring.cloud.stream.kafka.ordercheck.model;

import com.roytuts.spring.cloud.stream.kafka.ordercheck.enums.Status;

public class Order {

	private String uuid, name, item, status;

	public Order() {
		this.setStatus(Status.PENDING.name());
	}

	public Order(String uuid, String name, String item) {
		this.uuid = uuid;
		this.name = name;
		this.item = item;
		this.setStatus(Status.PENDING.name());
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals(Status.DELIVERED.name()) || status.equals(Status.UNDELIVERED.name())
				|| status.equals(Status.PENDING.name()) || status.equals(Status.REJECTED.name())) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Cannot set the Order's status to " + status);
		}
	}

	@Override
	public String toString() {
		return "Order [uuid=" + uuid + ", name=" + name + ", item=" + item + ", status=" + status + "]";
	}

}
