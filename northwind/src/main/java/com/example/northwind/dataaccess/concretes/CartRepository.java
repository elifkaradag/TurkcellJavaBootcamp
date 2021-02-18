package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.northwind.entities.concretes.Cart;
import com.example.northwind.entities.concretes.Product;

public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	@Query("select c from Cart c where c.productId = :productId AND c.customerId = :customerId")
	List<Cart> existByCustomerIdAndProductId(@Param("customerId") String customerId, @Param("productId") int productId);
	
	List<Cart> getCartsByCustomerId(String customerId);
	Cart findByProductId(int id);
}
