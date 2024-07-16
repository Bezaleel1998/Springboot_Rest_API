package com.Maven.SpringbootDuty.service;

import java.math.*;
import java.util.*;
import java.time.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Maven.SpringbootDuty.controller.OrderItemRequest;
import com.Maven.SpringbootDuty.entity.*;
import com.Maven.SpringbootDuty.repository.*;

@Service
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderItemRequest.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }
    
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    @Transactional
    public void addItemToOrder(Integer productId, Integer quantity, Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        logger.info("Get Order: {}", order.getCustomerName());
        
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        logger.info("Get Product: {}", product.getName());

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setOrderId(order.getId());
        orderItem.setProductId(product.getId());
        orderItem.setQuantity(quantity);
        orderItem.setTotal(product.getPrice().multiply(new BigDecimal(quantity)));
        orderItemRepository.save(orderItem);

        order.setTotal(order.getTotal().add(orderItem.getTotal()));
        orderRepository.save(order);
    }
    
}

