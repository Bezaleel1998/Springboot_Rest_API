package com.Maven.SpringbootDuty.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Maven.SpringbootDuty.entity.Order;
import com.Maven.SpringbootDuty.entity.OrderItem;
import com.Maven.SpringbootDuty.entity.Product;
import com.Maven.SpringbootDuty.service.OrderService;
import com.Maven.SpringbootDuty.service.ProductService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setCustomerAddress(request.getAddress());
        order.setTotal(BigDecimal.ZERO);

        for (OrderItemDto itemDto : request.getOrderItems()) {
            Optional<Product> productOpt = productService.getProductById(itemDto.getProductId());
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(itemDto.getQuantity());
                orderItem.setTotal(product.getPrice().multiply(new BigDecimal(itemDto.getQuantity())));
                orderItem.setOrder(order);

                order.getOrderItems().add(orderItem);
                order.setTotal(order.getTotal().add(orderItem.getTotal()));
            }
        }

        Order savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
    
    @PostMapping("/orderjson")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    
}

class PlaceOrderRequest {
    private String customerName;
    private String address;
    private List<OrderItemDto> orderItems;

    // Getters and setters

    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	
}

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