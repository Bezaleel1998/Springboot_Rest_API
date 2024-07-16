package com.Maven.SpringbootDuty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Maven.SpringbootDuty.entity.Order;
import com.Maven.SpringbootDuty.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping("/orderjson")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    
}