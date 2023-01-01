package com.pizzaapplication.entity;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlaceOrder {

	@Size(max=100,min=5,message="Location criteria not met")
	@NotNull(message="order Location is must")
	private String orderLocation;
	@Size(max=100,min=5,message="Description criteria not met")
	@NotNull(message="order Description is must")
	private String orderDescription;
	@Min(message="Customer Id must be 5 Digits", value=9999)
	@Max(message="Customer Id must be 5 Digits", value=100000)
	@Column(name="customerid")
	private int orderCustomerId;
	@Size(max=20,min=3,message="Transaction criteria not met")
	@NotNull(message="order tansaction mode is must")
	private String transactionMode;


	public String getOrderDescription() {
		return orderDescription;
	}
	public String getOrderLocation() {
		return orderLocation;
	}
	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public int getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


}