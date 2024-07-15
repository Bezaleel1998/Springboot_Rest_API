package com.Maven.SpringbootDuty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maven.SpringbootDuty.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
