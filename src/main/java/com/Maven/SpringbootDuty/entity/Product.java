package com.Maven.SpringbootDuty.entity;

import java.util.*;
import java.math.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private BigDecimal price;
    
    // Getters and Setters
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
