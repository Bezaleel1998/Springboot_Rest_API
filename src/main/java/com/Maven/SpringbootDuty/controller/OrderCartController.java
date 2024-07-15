package com.Maven.SpringbootDuty.controller;

import java.math.*;
import java.util.*;

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

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Order> addProductToCart(@RequestBody AddToCartRequest request) {
        Order order = orderService.addProductToCart(
                request.getProductId(),
                request.getQuantity()
        );
        return ResponseEntity.ok(order);
    }
    
    @PostMapping("/addjson")
    public ResponseEntity<?> addItemToCart(@RequestBody AddToCartRequest request) {
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

                order.getOrderItems().add(orderItem);
                order.setTotal(order.getTotal().add(orderItem.getTotal()));
                orderService.createOrder(order);

                return ResponseEntity.ok(order);
            } else {
                String errorMessage = "Product or Order not found";
                System.out.println(errorMessage);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> getCartItems() {
        List<OrderItem> cartItems = orderService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/submit")
    public ResponseEntity<Order> submitOrder(@RequestBody OrderSubmissionRequest request) {
        Order order = orderService.submitOrder(
                request.getCustomerName(),
                request.getCustomerAddress()
        );
        return ResponseEntity.ok(order);
    }

}
