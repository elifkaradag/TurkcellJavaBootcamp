package com.example.finalProject.business.abstracts;

import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.LimitationOfCredit;

public interface ILimitationOfCreditService {
	
	LimitationOfCredit addPostPaid(Customer customer);
	LimitationOfCredit addPrePaid(Customer customer);
	LimitationOfCredit addOther(Customer customer);

}
