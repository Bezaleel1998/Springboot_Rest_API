package com.Maven.SpringbootDuty.controller;

class OrderItemDto {
    
	private Integer productId;
    private Integer quantity;

    // Getters and setters
    public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}