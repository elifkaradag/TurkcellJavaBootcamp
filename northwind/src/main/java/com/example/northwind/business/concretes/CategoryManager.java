package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;

@Service
public class CategoryManager implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
//dene
	@Override
	public Category add(Category category) {
		
		
	    Category categoryToAdd = null;

		if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
			//System.out.println("Bu kategori daha önce eklendi");
			return categoryToAdd;
	    } else {
	    	categoryToAdd = categoryRepository.save(category);
	       return categoryToAdd;
	    }
		
		//return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) throws Exception{

		Category categoryToUpdate = categoryRepository.findById(category.getId())
				.orElseThrow(()->new Exception("no category with id :"+category.getId()));

		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setDescription(category.getDescription());

		Category updatedCategory = categoryRepository.save(categoryToUpdate);

		return updatedCategory;
	}

	@Override
	public Category delete(Category category) throws Exception {

		Category categoryDelete = categoryRepository.findById(category.getId())
				.orElseThrow(()->new Exception("no category with id :"+category.getId()));

		categoryRepository.delete(categoryDelete);

		return categoryDelete;
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}




}
