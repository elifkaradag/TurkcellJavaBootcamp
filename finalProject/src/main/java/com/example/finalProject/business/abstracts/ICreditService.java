package com.example.finalProject.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;

public interface ICreditService {
	
	List<Credit> viewCredits(Customer customer);
	Credit add(Credit credit,Customer customer);
	Credit update(Credit credit)throws Exception;
	Optional<Credit> delete(Credit credit,Customer customer);

}
