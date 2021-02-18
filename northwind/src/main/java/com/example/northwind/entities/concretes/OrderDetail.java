package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@IdClass(CompositeKey.class)
@Table(name="order_details")
public class OrderDetail implements IEntity{

	@Id
	@Column(name="order_id")
	private int orderId;
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="quantity")
	private int numberOfProducts;
	@Column(name="unit_price")
	private double unitPrice;

}
