package com.example.finalProject.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(name="credits")
public class Credit implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="loan_date")
	private Date loanDate;
	@Column(name="loan_repayment_date")
	private Date loanRepaymentDate;
	@Column(name="loan_amount")
	private double loanAmount;
	@Column(name="acceptance")
	private String acceptance;
	



}
