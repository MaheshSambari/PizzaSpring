package com.pizzaapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="lineitem")
public class LineItem {

	@SequenceGenerator(name = "s", sequenceName = "sno", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "s", strategy = GenerationType.SEQUENCE) 	
	@Id
	private int sno;
	@Min(message="Pizza Id must be 5 Digits", value=9999)
	@Max(message="Pizza Id must be 5 Digits", value=100000)
	@Column(name="pizzaid")
	private int pizzaId;
	@Min(message="Quantity must be 1 or above", value=1)
	@Max(message="Quantity must be below 20 or 20", value=20)
	private int quantity;
	@Size(max=13,min=5,message="pizza size criteria not met")
	@NotNull(message="pizza size is must")
	private String size;
	@Min(message="Customer Id must be 5 Digits", value=9999)
	@Max(message="Customer Id must be 5 Digits", value=100000)
	@Column(name="customerid")
	private int customerId;
	@Column(name="totalamount")
	private double totalAmount;


	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	


}