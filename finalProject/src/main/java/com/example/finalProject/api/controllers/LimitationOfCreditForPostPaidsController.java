package com.example.finalProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.business.abstracts.ILimitationOfCreditService;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.LimitationOfCredit;

@RestController
@RequestMapping("/api/v1")
public class LimitationOfCreditForPostPaidsController {
	
	@Autowired
	private ILimitationOfCreditService limitationOfCreditService;
	
	@PostMapping("/limitationOfCreditForPostPaids/{id}")
	public ResponseEntity<LimitationOfCredit> add(@PathVariable(value="id") int customerId, LimitationOfCredit limitationOfCredit) {

		Customer customer = new Customer();
		customer.setId(customerId);
		
		LimitationOfCredit addedLimitationOfCreditService = limitationOfCreditService.addPostPaid(customer);

		return ResponseEntity.ok(addedLimitationOfCreditService);

	}

}
