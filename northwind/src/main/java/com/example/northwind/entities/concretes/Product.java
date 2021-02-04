package com.example.northwind.entities.concretes;

import javax.persistence.*;


import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	@Column(name="category_id")
	private int categoryId;
	@Column(name="supplier_id")
	private int supplierId;
	@Column(name="product_name")
	private String productName;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;


}
