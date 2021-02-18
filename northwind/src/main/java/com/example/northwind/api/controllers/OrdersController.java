package com.example.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.entities.concretes.Order;

@RestController
@RequestMapping("/api/v1")
public class OrdersController {
	
	@Autowired
	private IOrderService orderService;

	@PostMapping("/orders/{id}")
	public ResponseEntity<Order> add(@PathVariable(value="id") String customerId,  @RequestBody Order order) {
		
		order.setCustomerId(customerId);
		
		Order addedOrder = orderService.sellProduct(order);

		return ResponseEntity.ok(addedOrder);

	}

}
