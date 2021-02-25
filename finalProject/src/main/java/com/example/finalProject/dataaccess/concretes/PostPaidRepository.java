package com.example.finalProject.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finalProject.entities.concretes.PostPaid;

public interface PostPaidRepository  extends JpaRepository<PostPaid,Integer>{
	
	List<PostPaid> getPostPaidsByCustomerId(int customerId);

}
