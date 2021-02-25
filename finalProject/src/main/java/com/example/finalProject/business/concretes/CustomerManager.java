package com.example.finalProject.business.concretes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.business.abstracts.ICustomerService;
import com.example.finalProject.dataaccess.concretes.CustomerRepository;
import com.example.finalProject.entities.concretes.Customer;

@Service
public class CustomerManager implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer add(Customer customer) {
		
		LocalDate dateTime = java.time.LocalDate.now();
		Date date = Date.valueOf(dateTime);
		customer.setSubscriptionDate(date);
		
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> delete(Customer customer) {
		Optional<Customer> customerDelete = customerRepository.findById(customer.getId());
		customerRepository.delete(customer);

		return customerDelete;
	}


	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
