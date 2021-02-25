package com.example.finalProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.business.abstracts.ICustomerService;
import com.example.finalProject.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class CustomersController {
	

	@Autowired
	private ICustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> add(@RequestBody Customer customer) {

		Customer addedCustomer = customerService.add(customer);

		return ResponseEntity.ok(addedCustomer);

	}

}
