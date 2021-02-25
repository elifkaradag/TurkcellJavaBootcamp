package com.example.finalProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.time.*; 
import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.business.abstracts.IConfirmationService;
import com.example.finalProject.dataaccess.concretes.BlackListRepository;
import com.example.finalProject.dataaccess.concretes.ConfirmationRepository;
import com.example.finalProject.dataaccess.concretes.CreditRepository;
import com.example.finalProject.dataaccess.concretes.LimitationOfCreditRepository;
import com.example.finalProject.entities.concretes.BlackList;
import com.example.finalProject.entities.concretes.Confirmation;
import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.LimitationOfCredit;

@Service
public class ConfirmationManager implements IConfirmationService{

	@Autowired
	private ConfirmationRepository confirmationRepository;

	@Autowired
	private CreditRepository creditRepository;

	@Autowired
	private LimitationOfCreditRepository limitationOfCreditRepository;

	@Autowired
	private BlackListRepository blackListRepository;


	@Override
	public Confirmation checkLoan(Confirmation confirmation, Credit credit) throws Exception{

		Credit loan = creditRepository.findById(credit.getId())
				.orElseThrow(()->new Exception("no category with id :"+credit.getId()));

		LimitationOfCredit limitationOfCredit = limitationOfCreditRepository.findByCustomerId(loan.getCustomerId());//credit.getCustomerId());
		List<Credit> credits = creditRepository.getCreditsByCustomerIdAndAcceptance(loan.getCustomerId());
		BlackList blackList = blackListRepository.findByCustomerId(loan.getCustomerId());

		Double sumLoan = loan.getLoanAmount();

		if(blackList != null) {
			System.out.println("Kullanıcı kara listede. Kredi Reddedildi!!!");
			loan.setAcceptance("reddedildi");
		}
		else {

			if(!isValidDay(loan)) {
				System.out.println("Kullanıcı bu ay kredi kullandı");
				loan.setAcceptance("reddedildi");
			}
			else {

				if(loan.getLoanAmount() > limitationOfCredit.getMaxAmountForOneLoan()) {
					System.out.println("Kredi Limiti uygun değildir. Kredi miktarını güncelleyiniz!");
					loan.setAcceptance("Kredi miktarını güncelleyiniz.");
				}
				else {

					for(Credit credit1 : credits) {
						sumLoan += credit1.getLoanAmount();
					}

					if(sumLoan >= limitationOfCredit.getMaxTotalAmount()) {
						System.out.println("yıllık maksimum limit doldu. Kredi Reddedildi!!!");
						loan.setAcceptance("reddedildi");
					}
					else {
						loan.setAcceptance("onaylandı");
					}
				}
			}
		}
		confirmation.setCreditId(loan.getId());
		confirmation.setLoanResult(loan.getAcceptance());
		creditRepository.save(loan);
		return confirmationRepository.save(confirmation);


	}

	@Override
	public boolean isValidDay(Credit credit) {

		//LocalDate dateTime = java.time.LocalDate.now();

		LocalDate loanDate = LocalDate.of(credit.getLoanDate().getYear() + 1900, credit.getLoanDate().getMonth() + 1, credit.getLoanDate().getDate());
		List<Credit> credits = creditRepository.getCreditsByCustomerId(credit.getCustomerId());

		int min = 10000;

		for(Credit credit1 : credits) {

			if(credit1.getAcceptance().equalsIgnoreCase("onaylandı")) {

				LocalDate loanDate1 = LocalDate.of(credit1.getLoanDate().getYear() + 1900, credit1.getLoanDate().getMonth() + 1, credit1.getLoanDate().getDate());

				Period diff = Period.between(loanDate1, loanDate); 
				int sumOfDay = diff.getDays() + diff.getMonths()*30 + diff.getYears()*365;

				if(min > sumOfDay)
					min = sumOfDay;
			}
		}

		if(min < 30 )
			return false;
		else
			return true;
	}



}
