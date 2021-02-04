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

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	@PostMapping("/products")
	public Product add(@RequestBody Product product) throws Exception {
		
		return productService.add(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> update(@PathVariable(value="id") Integer productId,@RequestBody Product product) throws Exception {
		product.setId(productId);
		Product updatedProduct = productService.update(product);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> delete(@PathVariable(value="id") Integer productId,@RequestBody Product product) throws Exception {
		product.setId(productId);
		Product detetedProduct = productService.delete(product);
		
		return ResponseEntity.ok(detetedProduct);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Optional<Product>> getCategoryById(@PathVariable(value="id") Integer productId){
		
		Optional<Product> getOneProduct = productService.getProductById(productId);
		
		return ResponseEntity.ok(getOneProduct);
	}
}
