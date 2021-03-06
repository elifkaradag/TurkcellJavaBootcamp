package com.example.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IOrderDetailService;
import com.example.northwind.dataaccess.concretes.OrderDetailRepository;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements IOrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetail> viewOrderDetail(Order order) {
		List<OrderDetail> orderDetailToView = orderDetailRepository.getOrderDetailByOrderId(order.getId());
		return orderDetailToView;
	}
}
