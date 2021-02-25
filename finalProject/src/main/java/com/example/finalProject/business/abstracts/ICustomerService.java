package com.example.finalProject.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.finalProject.entities.concretes.Customer;


public interface ICustomerService {
	
	List<Customer> getAll();
	Customer add(Customer customer);
	Customer update(Customer customer);
	Optional<Customer> delete(Customer customer);
	

}
