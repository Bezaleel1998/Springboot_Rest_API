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

    private static final Logger logger = LoggerFactory.getLogger(OrderCartController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addjson")
    public ResponseEntity<?> addItemToCart(@RequestBody AddToCartRequest request) {
        logger.info("addItemToCart called with request: {}", request);
        try {
            Optional<Product> productOpt = productService.getProductById(request.getProductId());
            Optional<Order> orderOpt = orderService.getOrderById(request.getOrderId());

            if (productOpt.isPresent() && orderOpt.isPresent()) {
                Product product = productOpt.get();
                Order order = orderOpt.get();
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(product.getId());
                orderItem.setQuantity(request.getQuantity());
                orderItem.setTotal(product.getPrice().multiply(new BigDecimal(request.getQuantity())));
                orderItem.setOrderId(order.getId());

                logger.info("Adding order item: {}", orderItem);
                order.getOrderItems().add(orderItem);
                order.setTotal(order.getTotal().add(orderItem.getTotal()));

                logger.info("Updating order: {}", order);
                orderService.createOrder(order);

                logger.info("Order updated successfully: {}", order);
                return ResponseEntity.ok(order);
            } else {
                String errorMessage = "Product or Order not found";
                logger.error(errorMessage);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            logger.error("Error occurred while adding item to cart", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}