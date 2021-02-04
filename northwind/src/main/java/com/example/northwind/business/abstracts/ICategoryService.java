package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.northwind.entities.concretes.Category;


public interface ICategoryService {
	List<Category> getAll();
	Category add(Category category);
	Category update(Category category) throws Exception;
	Category delete(Category category) throws Exception;
	Optional<Category> getCategoryById(int id);
}
