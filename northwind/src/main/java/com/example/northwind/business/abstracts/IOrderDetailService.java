package com.example.northwind.business.abstracts;

import java.util.List;

import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

public interface IOrderDetailService {
	
	List<OrderDetail> viewOrderDetail(Order order);

}
