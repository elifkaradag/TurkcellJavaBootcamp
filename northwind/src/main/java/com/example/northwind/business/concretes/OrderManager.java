package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.dataaccess.concretes.CartRepository;
import com.example.northwind.dataaccess.concretes.OrderDetailRepository;
import com.example.northwind.dataaccess.concretes.OrderRepository;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Cart;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetail;
import com.example.northwind.entities.concretes.Product;

@Service
public class OrderManager implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Order sellProduct(Order order) {
		
		List<Cart> carts = cartRepository.getCartsByCustomerId(order.getCustomerId());
		Order sellOrder = orderRepository.save(order);
		
		for(Cart cart : carts) {
			
			OrderDetail orderDetail = new OrderDetail();
			Product product = productRepository.getOneProductById(cart.getProductId());
			
			orderDetail.setOrderId(order.getId());
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setNumberOfProducts(cart.getNumberOfProducts());
			orderDetail.setUnitPrice(product.getUnitPrice());
			
			
			orderDetailRepository.save(orderDetail);
			cartRepository.delete(cart);
			
		}
		return sellOrder;
	}

}
