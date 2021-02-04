package com.example.northwind.dataaccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

	boolean existsByCategoryName(String categoryName); 
	

}