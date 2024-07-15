package com.Maven.SpringbootDuty.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maven.SpringbootDuty.entity.*;
import com.Maven.SpringbootDuty.repository.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }
    
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public Order addProductToCart(Integer productId, Integer quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!productOpt.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOpt.get();
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setTotal(BigDecimal.ZERO);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setTotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        orderItem.setOrder(order);

        order.getOrderItems().add(orderItem);
        order.setTotal(order.getTotal().add(orderItem.getTotal()));

        return orderRepository.save(order);
    }

    public List<OrderItem> getCartItems() {
        // Assuming there is only one order at a time. In a real application, you'd have logic to get the current order.
        return orderItemRepository.findAll();
    }

    public Order submitOrder(String customerName, String customerAddress) {
        // Assuming there is only one order at a time. In a real application, you'd have logic to get the current order.
        Order order = orderRepository.findAll().get(0); // Get the first order for simplicity
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        return orderRepository.save(order);
    }
    
}

