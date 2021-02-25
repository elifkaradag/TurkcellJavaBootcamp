package com.example.finalProject.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entities.concretes.PrePaid;

public interface PrePaidRepository extends JpaRepository<PrePaid,Integer>{
	
	List<PrePaid> getPrePaidsByCustomerId(int customerId);

}
