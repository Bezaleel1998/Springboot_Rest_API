package com.Maven.SpringbootDuty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maven.SpringbootDuty.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
