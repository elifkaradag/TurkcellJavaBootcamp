package com.example.finalProject.business.abstracts;

import com.example.finalProject.entities.concretes.Confirmation;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.LimitationOfCredit;

public interface IConfirmationService {
	
	Confirmation checkLoan(Confirmation confirmation, Credit credit)throws Exception;
	boolean isValidDay(Credit credit);

}
