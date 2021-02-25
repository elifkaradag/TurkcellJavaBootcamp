package com.example.finalProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.business.abstracts.ICreditService;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class CreditsController {
	
	@Autowired
	private ICreditService creditService;

	@GetMapping("/credits/{id}")
	public List<Credit> viewCredits(@PathVariable(value="id") int customerId){
		Customer customer = new Customer();
		customer.setId(customerId);
		
		return creditService.viewCredits(customer);
	}

	@PostMapping("/credits/{id}")
	public ResponseEntity<Credit> add(@PathVariable(value="id") String identityNumber, @RequestBody Credit credit) {

		Customer customer = new Customer();
		customer.setIdentityNumber(identityNumber);
		
		Credit addedCredit = creditService.add(credit, customer);

		return ResponseEntity.ok(addedCredit);

	}
	
	@PutMapping("/credits/{id}")
	public ResponseEntity<Credit> update(@PathVariable(value="id") Integer creditId,@RequestBody Credit credit) throws Exception {
		
		credit.setId(creditId);
		Credit updatedCredit = creditService.update(credit);
		
		return ResponseEntity.ok(updatedCredit);
	}

/*	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Category> delete(@PathVariable(value="id") Integer categoryId,@RequestBody Category category) throws Exception {
		category.setId(categoryId);
		Category detetedCategory = categoryService.delete(category);

		return ResponseEntity.ok(detetedCategory);
	}*/

}
