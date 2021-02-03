package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {

		return productRepository.findAll();
	}

	@Override
	public Product add(Product product) throws Exception {

		List<Product> products = productRepository.getProductsByCategoryId(product.getCategoryId());
		int numberOfProduct = products.size();

		if(product.getProductName().length()<2) {
			//hata
			 throw new Exception("Ürün ismi 2 karakterden küçük olamaz.");
		}
		if(numberOfProduct>9) {
			//hata
			 throw new Exception("Bir kategoriye 10 dan fazla ürün eklenemez");

		}
		//productRepository.save(product);

		return productRepository.save(product);
		
	}
	
	@Override
	public Product update(Product product) throws Exception{

		Product productToUpdate = productRepository.findById(product.getId())
				.orElseThrow(()->new Exception("no product with id :"+product.getId()));

		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setQuantityPerUnit(product.getQuantityPerUnit());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		productToUpdate.setSupplierId(product.getSupplierId());
		

		Product updatedProduct = productRepository.save(productToUpdate);

		return updatedProduct;
	}

	@Override
	public Product delete(Product product) throws Exception {

		Product productDelete = productRepository.findById(product.getId())
				.orElseThrow(()->new Exception("no product with id :"+product.getId()));

		productRepository.delete(productDelete);

		return productDelete;
	}

	@Override
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

  

}
