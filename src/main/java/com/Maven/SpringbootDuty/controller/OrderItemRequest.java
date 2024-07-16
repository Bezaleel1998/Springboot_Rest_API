package com.Maven.SpringbootDuty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderItemRequest {
	private static final Logger logger = LoggerFactory.getLogger(OrderItemRequest.class);

    private Integer productId;
    private Integer quantity;
    private Integer orderId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        logger.info("Setting productId: {}", productId);
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        logger.info("Setting quantity: {}", quantity);
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        logger.info("Setting orderId: {}", orderId);
        this.orderId = orderId;
    }
}
