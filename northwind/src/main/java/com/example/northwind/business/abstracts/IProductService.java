package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {
	
	List<Product> getAll();
	Product add(Product product) throws Exception;
	Optional<Product> getProductById(int id);
	Product update(Product product) throws Exception;
	Product delete(Product product) throws Exception;

}
