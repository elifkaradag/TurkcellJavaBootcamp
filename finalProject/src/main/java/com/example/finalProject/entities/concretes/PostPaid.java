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
@Table(name="post_paids")
public class PostPaid implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="amount_of_bill")
	private double amountOfBill;
	@Column(name="bill_date")
	private Date billDate;
	@Column(name="payment_date")
	private Date paymentDate;

}
