package com.pizzaapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order1")
public class Order {
	@Column(name="orderlocation")
	private String orderLocation;

	@Id
	@SequenceGenerator(name = "order", sequenceName = "order_sequence", initialValue = 50000, allocationSize = 1)
	@GeneratedValue(generator = "order", strategy = GenerationType.SEQUENCE)  	  
	@Column(name="orderid")
	private int orderId;

	@Column(name="orderdescription")
	private String orderDescription;

	@Column(name="orderamount")
	private double orderAmount;

	@ManyToOne(cascade=CascadeType.ALL )
	@JoinColumn(name="ordercustomerid" )
	private Customer orderCustomerId;

	// getters and setters
	public String getOrderLocation() {
		return orderLocation;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public Customer getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(Customer orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}
	public Set<PizzaOrder> getPizzaOrders() {
		return pizzaOrders;
	}
	public void setPizzaOrders(Set<PizzaOrder> pizzaOrders) {
		this.pizzaOrders = pizzaOrders;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<PizzaOrder> pizzaOrders = new HashSet<>();

}