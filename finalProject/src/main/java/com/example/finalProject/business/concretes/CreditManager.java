package com.example.finalProject.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.business.abstracts.ICreditService;
import com.example.finalProject.dataaccess.concretes.BlackListRepository;
import com.example.finalProject.dataaccess.concretes.CreditRepository;
import com.example.finalProject.dataaccess.concretes.CustomerRepository;
import com.example.finalProject.dataaccess.concretes.LimitationOfCreditRepository;
import com.example.finalProject.entities.concretes.BlackList;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.LimitationOfCredit;

@Service
public class CreditManager implements ICreditService{

	@Autowired
	private CreditRepository creditRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Credit> viewCredits(Customer customer) {
		List<Credit> cartToView = creditRepository.getCreditsByCustomerId(customer.getId());
		return cartToView;	
	}

	@Override
	public Credit add(Credit credit, Customer customer) {

		Customer loanCustomer = customerRepository.findByIdentityNumber(customer.getIdentityNumber());

		if(loanCustomer == null) {
			System.out.println("Lütfen önce sisteme kaydolunuz.");
			return null;
		}
		else {
			LocalDate dateTime = java.time.LocalDate.now();
			Date loanDate = Date.valueOf(dateTime);
			
			credit.setCustomerId(loanCustomer.getId());
			credit.setAcceptance("işleme alındı");
			credit.setLoanDate(loanDate);
			return creditRepository.save(credit);
		}
	}

	@Override
	public Credit update(Credit credit)throws Exception{

		Credit creditToUpdate = creditRepository.findById(credit.getId())
				.orElseThrow(()->new Exception("no credit with id :"+credit.getId()));
				
		creditToUpdate.setLoanAmount(credit.getLoanAmount());
		creditToUpdate.setLoanDate(credit.getLoanDate());
		creditToUpdate.setLoanRepaymentDate(credit.getLoanRepaymentDate());
		creditToUpdate.setAcceptance("işleme alındı");
		
		Credit updatedCredit = creditRepository.save(creditToUpdate);

		return updatedCredit;

	}

	@Override
	public Optional<Credit> delete(Credit credit, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}



}
