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
@Table(name="daily_reports")
public class DailyReporting implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="date")
	private Date date;
	@Column(name="number_of_subscriptions")
	private int numberOfSubscriptions;
	@Column(name="total_loan_amount")
	private double totalLoanAmount;


}
