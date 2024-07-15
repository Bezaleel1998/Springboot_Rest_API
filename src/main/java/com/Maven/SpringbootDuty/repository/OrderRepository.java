package com.Maven.SpringbootDuty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maven.SpringbootDuty.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
