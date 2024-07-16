package com.Maven.SpringbootDuty.controller;

import java.math.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Maven.SpringbootDuty.entity.Order;
import com.Maven.SpringbootDuty.entity.OrderItem;
import com.Maven.SpringbootDuty.entity.Product;
import com.Maven.SpringbootDuty.service.OrderService;
import com.Maven.SpringbootDuty.service.ProductService;

@RestController
@RequestMapping("/api/cart")
public class OrderCartController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/addjson")
    public ResponseEntity<String> addItemToCart(@RequestBody OrderItemRequest orderItemRequest) {
    	 orderService.addItemToOrder(
    			 orderItemRequest.getProductId(), 
    			 orderItemRequest.getQuantity(), 
    			 orderItemRequest.getOrderId()
    			 );
    	 
         String responseMessage = "Order item added successfully";
         
         return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }
    
}