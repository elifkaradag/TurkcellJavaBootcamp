package com.example.finalProject.dataaccess.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.finalProject.entities.concretes.Credit;
import com.example.finalProject.entities.concretes.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	Customer findByIdentityNumber(String identityNumber);
	
	@Query("select count (c) from Customer c where c.subscriptionDate = :subscriptionDate")
	int getNumberOfCustomerBySubscriptionDate(Date subscriptionDate);

}
