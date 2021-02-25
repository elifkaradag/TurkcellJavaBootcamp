package com.example.finalProject.business.concretes;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.business.abstracts.ILimitationOfCreditService;
import com.example.finalProject.dataaccess.concretes.CustomerRepository;
import com.example.finalProject.dataaccess.concretes.LimitationOfCreditRepository;
import com.example.finalProject.dataaccess.concretes.PostPaidRepository;
import com.example.finalProject.dataaccess.concretes.PrePaidRepository;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.LimitationOfCredit;
import com.example.finalProject.entities.concretes.PostPaid;
import com.example.finalProject.entities.concretes.PrePaid;

@Service
public class LimitationOfCreditManager implements ILimitationOfCreditService{

	@Autowired
	private LimitationOfCreditRepository limitationOfCreditRepository;
	
	@Autowired
	private PostPaidRepository postPaidRepository;
	
	@Autowired
	private PrePaidRepository prePaidRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public LimitationOfCredit addPostPaid(Customer customer) {
		
		List<PostPaid> postPaids = postPaidRepository.getPostPaidsByCustomerId(customer.getId());
		Optional<Customer> customer1 = customerRepository.findById(customer.getId());

		double sumOfPills = 0.0;
		int sumOfDay = 0;
		int numberOfBill = 0;

		for(PostPaid postPaid1 : postPaids) {

			sumOfPills+= postPaid1.getAmountOfBill();

			LocalDate billDate = LocalDate.of(postPaid1.getBillDate().getYear() + 1900, postPaid1.getBillDate().getMonth() + 1, postPaid1.getBillDate().getDate());
			LocalDate paymentDate = LocalDate.of(postPaid1.getPaymentDate().getYear() + 1900, postPaid1.getPaymentDate().getMonth() + 1, postPaid1.getPaymentDate().getDate());

			Period diff = Period.between(billDate,paymentDate); 
			System.out.println(sumOfDay);
			sumOfDay += diff.getDays() + diff.getMonths()*30 + diff.getYears()*365;

			numberOfBill++;
		}

		LocalDate nowDate = java.time.LocalDate.now(); 

		int sumOfsubscriptionDay = nowDate.getYear() - customer1.get().getSubscriptionDate().getYear();
		double amountOfLoanForOneMonth = (sumOfDay / numberOfBill)*100 + sumOfPills + sumOfsubscriptionDay*10;

		LimitationOfCredit limitationOfCredit = new LimitationOfCredit();

		limitationOfCredit.setCustomerId(customer.getId());
		limitationOfCredit.setMaxAmountForOneLoan(Math.ceil(amountOfLoanForOneMonth));
		limitationOfCredit.setMaxTotalAmount(Math.ceil(amountOfLoanForOneMonth)*12);

		return limitationOfCreditRepository.save(limitationOfCredit);
	
	}

	@Override
	public LimitationOfCredit addPrePaid(Customer customer) {
		
		List<PrePaid> prePaids = prePaidRepository.getPrePaidsByCustomerId(customer.getId());
		Optional<Customer> customer1 = customerRepository.findById(customer.getId());

		double sumOfloadingAmaount = 0.0;
		int numberOfLoading = 0;

		for(PrePaid prePaid1 : prePaids) {
			sumOfloadingAmaount+= prePaid1.getLoadingAmount();
			numberOfLoading++;
		}

		LocalDate nowDate = java.time.LocalDate.now(); 

		int sumOfsubscriptionDay = nowDate.getYear() - customer1.get().getSubscriptionDate().getYear();
		double amountOfLoanForOneMonth = (sumOfloadingAmaount / numberOfLoading)*100 + sumOfsubscriptionDay*10;

		LimitationOfCredit limitationOfCredit = new LimitationOfCredit();

		limitationOfCredit.setCustomerId(customer.getId());
		limitationOfCredit.setMaxAmountForOneLoan(Math.ceil(amountOfLoanForOneMonth));
		limitationOfCredit.setMaxTotalAmount(Math.ceil(amountOfLoanForOneMonth)*12);

		return limitationOfCreditRepository.save(limitationOfCredit);
	
	}

	@Override
	public LimitationOfCredit addOther(Customer customer) {
		
		LimitationOfCredit limitationOfCredit = new LimitationOfCredit();

		limitationOfCredit.setCustomerId(customer.getId());
		limitationOfCredit.setMaxAmountForOneLoan(1000);
		limitationOfCredit.setMaxTotalAmount(1000*12);

		return limitationOfCreditRepository.save(limitationOfCredit);
	
	}

}
