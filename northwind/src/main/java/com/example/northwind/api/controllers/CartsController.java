package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICartService;
import com.example.northwind.entities.concretes.Cart;
import com.example.northwind.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class CartsController {
	
	@Autowired
	private ICartService cartService;

	@GetMapping("/carts/{id}")
	public List<Cart> viewCart(@PathVariable(value="id") String customerId){
		Customer customer = new Customer();
		customer.setId(customerId);
		
		return cartService.viewCart(customer);
	}

	@PostMapping("/carts")
	public ResponseEntity<Cart> add(@RequestBody Cart cart) {
		
		Cart addedCart = cartService.addProduct(cart);

		return ResponseEntity.ok(addedCart);

	}
	
	@DeleteMapping("/carts/{id}/{id1}/{numberOfElement}")
	public ResponseEntity<Cart> delete(@PathVariable(value="id") String customerId,@PathVariable(value="id1") Integer productId, 
			@PathVariable(value="numberOfElement") Integer numberOfElement){
		
		Cart cart = new Cart();
		
		cart.setCustomerId(customerId);
		cart.setProductId(productId);

		Cart detetedCart = cartService.removeProduct(cart,numberOfElement);

		return ResponseEntity.ok(detetedCart);
	}


}
