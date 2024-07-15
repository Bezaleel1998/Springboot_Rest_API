package com.Maven.SpringbootDuty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maven.SpringbootDuty.entity.Order;
import com.Maven.SpringbootDuty.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }
    
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
}
