package com.example.finalProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.business.abstracts.IConfirmationService;
import com.example.finalProject.entities.concretes.Confirmation;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class ConfirmationsController {
	
	@Autowired
	private IConfirmationService confirmationService;
	
	@PostMapping("/confirmations/{id}")
	public ResponseEntity<Confirmation> add(@PathVariable(value="id") int creditId, @RequestBody Confirmation confirmation) throws Exception {
		Credit credit = new Credit();
		credit.setId(creditId);
		
		Confirmation addedConfirmation = confirmationService.checkLoan(confirmation, credit);

		return ResponseEntity.ok(addedConfirmation);

	}

}
