package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;

@RestController
@RequestMapping("/api/v1")
public class CategoriesConroller {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> getAll(){
		return categoryService.getAll();
	}

	@PostMapping("/categories")
	public ResponseEntity<Category> add(@RequestBody Category category) {

		Category addedCategory = categoryService.add(category);

		if(addedCategory == null) {
			System.out.println("Bu kategori daha önce eklendi.");
		}

		return ResponseEntity.ok(addedCategory);

	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> update(@PathVariable(value="id") Integer categoryId,@RequestBody Category category) throws Exception {
		category.setId(categoryId);
		Category updatedCategory = categoryService.update(category);
		
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Category> delete(@PathVariable(value="id") Integer categoryId,@RequestBody Category category) throws Exception {
		category.setId(categoryId);
		Category detetedCategory = categoryService.delete(category);

		return ResponseEntity.ok(detetedCategory);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable(value="id") Integer categoryId){

		Optional<Category> getOneCategory = categoryService.getCategoryById(categoryId);

		return ResponseEntity.ok(getOneCategory);
	}



}
