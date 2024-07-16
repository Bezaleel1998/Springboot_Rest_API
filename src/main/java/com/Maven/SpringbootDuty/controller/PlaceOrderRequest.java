package com.Maven.SpringbootDuty.controller;

import java.util.List;

class PlaceOrderRequest {
    private String customerName;
    private String address;
    private List<OrderItemDto> orderItems;

    // Getters and setters

    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	
}
