package com.example.finalProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.finalProject.entities.abstracts.IEntity;
import com.example.finalProject.entities.concretes.Customer;

import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	//@Column(name="credit_id")
	//private int creditId;
	@Column(name="identity_number")
	private String identityNumber;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="msisdn")
	private String msisdn;
	@Column(name="address")
	private String address;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="type_of_customer")
	private String typeOfCustomer;
	@Column(name="subscription_date")
	private Date subscriptionDate;
	@Column(name="identification")
	private String identification;
	
	
	
	

}
