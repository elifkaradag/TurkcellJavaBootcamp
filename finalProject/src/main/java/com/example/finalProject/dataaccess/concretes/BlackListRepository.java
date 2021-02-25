package com.example.finalProject.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entities.concretes.BlackList;
import com.example.finalProject.entities.concretes.Customer;

public interface BlackListRepository extends JpaRepository<BlackList,Integer>{

	BlackList findByCustomerId(int customerId);

}
