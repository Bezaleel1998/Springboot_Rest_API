package com.Maven.SpringbootDuty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maven.SpringbootDuty.entity.OrderItem;
import com.Maven.SpringbootDuty.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }
}
