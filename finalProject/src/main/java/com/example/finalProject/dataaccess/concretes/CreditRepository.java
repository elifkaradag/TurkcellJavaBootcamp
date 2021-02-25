package com.example.finalProject.dataaccess.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.finalProject.entities.concretes.Credit;


public interface CreditRepository extends JpaRepository<Credit,Integer>{

	List<Credit> getCreditsByCustomerId(int customerId);
	Credit findByCustomerIdAndAcceptance(int customerId, String acceptance);
	
	@Query("select c from Credit c where c.customerId =:customerId and c.acceptance ='onaylandı'")
	List<Credit> getCreditsByCustomerIdAndAcceptance(@Param("customerId") int customerId);
	
	@Query("select c from Credit c where c.loanDate =:loanDate and c.acceptance ='onaylandı'")
	List<Credit> getCreditsByLoanDate(Date loanDate);
}
