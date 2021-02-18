package com.example.northwind.business.abstracts;

import java.util.List;

import com.example.northwind.entities.concretes.Cart;
import com.example.northwind.entities.concretes.Customer;

public interface ICartService {
	
	List<Cart> viewCart(Customer customer);
	Cart addProduct(Cart cart);
	Cart removeProduct(Cart cart, int number);

}
