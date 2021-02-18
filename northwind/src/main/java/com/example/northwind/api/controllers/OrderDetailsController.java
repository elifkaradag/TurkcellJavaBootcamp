package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IOrderDetailService;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

@RestController
@RequestMapping("/api/v1")
public class OrderDetailsController {
	
	@Autowired
	private IOrderDetailService orderDetailService;

	@GetMapping("/orderDetails/{id}")
	public List<OrderDetail> viewOrderDetail(@PathVariable(value="id") int orderId){
		Order order = new Order();
		order.setId(orderId);
		
		return orderDetailService.viewOrderDetail(order);
	}

}
