package com.example.finalProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.finalProject.entities.abstracts.IEntity;
import lombok.Data;

@Data
@Entity
@Table(name="pre_paids")
public class PrePaid implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="loading_amount")
	private double loadingAmount;
	@Column(name="loading_date")
	private Date loadingDate;
}
