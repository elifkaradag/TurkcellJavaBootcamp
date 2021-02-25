package com.example.finalProject.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entities.concretes.LimitationOfCredit;

public interface LimitationOfCreditRepository extends JpaRepository<LimitationOfCredit,Integer>{

	LimitationOfCredit findByCustomerId(int customerId);
}
