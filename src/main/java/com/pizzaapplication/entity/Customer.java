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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Column(name="customerid")
	@SequenceGenerator(name = "cust", sequenceName = "customer_sequence", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(generator = "cust", strategy = GenerationType.SEQUENCE) 	
	@Id
	private int customerId;
	
	@Column(name="customername")
	@NotNull(message ="name is must")
	private String customerName;
	
	@Column(name="customermobile")
	@Min(message ="valid mobile number is must",value=999999999)
	private long customerMobile;
	
	@Column(name="customeremailid")
	@NotNull(message ="mail id is must")
	private String customerEmailId;
	
	@Column(name="customeraddress")
	@NotNull(message ="Address is must")
	private String customerAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid", unique = true)
	@NotNull(message ="user password is must")
	private UserLogin userModel;
	
	// getters and setters

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
	public UserLogin getUserModel() {
		return userModel;
	}
	public void setUserModel(UserLogin userModel) {
		this.userModel = userModel;
	}
	
}
