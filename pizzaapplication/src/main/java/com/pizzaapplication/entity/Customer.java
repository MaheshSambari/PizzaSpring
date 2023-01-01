package com.pizzaapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	@Column(name="customerid")
	@SequenceGenerator(name = "cust", sequenceName = "customer_sequence", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(generator = "cust", strategy = GenerationType.SEQUENCE) 	@Id
	private int customerId;
	@Column(name="customername")
	@NotNull(message ="name is must")
	private String customerName;
	@Column(name="customermobile")
	@NotNull(message ="mobile number is must")
	private long customerMobile;
	@Column(name="customeremailid")
	@NotNull(message ="mail id is must")
	private String customerEmailId;
	@Column(name="customeraddress")
	@NotNull(message ="Address is must")
	private String customerAddress;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid", unique = true)
	private UserLogin user;


	public int getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public long getCustomerMobile() {
		return customerMobile;
	}


	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}


	public String getCustomerEmailId() {
		return customerEmailId;
	}


	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public UserLogin getUser() {
		return user;
	}


	public void setUser(UserLogin user) {
		this.user = user;
	}
	
 
	
}
