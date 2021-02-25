package com.example.finalProject.business.concretes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.business.abstracts.IDailyReportingService;
import com.example.finalProject.dataaccess.concretes.CreditRepository;
import com.example.finalProject.dataaccess.concretes.CustomerRepository;
import com.example.finalProject.dataaccess.concretes.DailyReportingRepository;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;
import com.example.finalProject.entities.concretes.DailyReporting;

@Service
public class DailyReportingManager implements IDailyReportingService{

	@Autowired
	private DailyReportingRepository dailyReportingRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CreditRepository creditRepository;

	@Override
	public DailyReporting getDailyReportByDate(Date date) {

		DailyReporting reportToView = dailyReportingRepository.findByDate(date);
		return reportToView;	

	}

	@Override
	public DailyReporting add(DailyReporting reporting) throws IOException {

		LocalDate nowDate = java.time.LocalDate.now(); 
		Date date = Date.valueOf(nowDate);
		
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter("c:/Users/Lenovo/Desktop/dailyReport.pdf", true));

		List<Credit> credits = creditRepository.getCreditsByLoanDate(date);
		int numberOfCustomer = customerRepository.getNumberOfCustomerBySubscriptionDate(date);

		double totalCreditAmount = 0.0;


		for(Credit credit1 : credits) {
			totalCreditAmount+=credit1.getLoanAmount();
		}

		
		fileWriter.append("Date: "+date+", "+"Total Loan Amount: "+ totalCreditAmount +", "+"Number of Customers: "+numberOfCustomer);
		fileWriter.newLine();
		fileWriter.close();

		reporting.setDate(date);
		reporting.setTotalLoanAmount(totalCreditAmount);
		reporting.setNumberOfSubscriptions(numberOfCustomer);

		return dailyReportingRepository.save(reporting);	

	}




}
