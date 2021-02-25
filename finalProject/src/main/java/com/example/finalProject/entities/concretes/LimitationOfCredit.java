package com.example.finalProject.entities.concretes;

import java.util.Date;

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
@Table(name="limitation_of_credits")
public class LimitationOfCredit implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="max_total_amount")
	private double maxTotalAmount;
	@Column(name="max_amount_for_one_loan")
	private double maxAmountForOneLoan;
	

}
