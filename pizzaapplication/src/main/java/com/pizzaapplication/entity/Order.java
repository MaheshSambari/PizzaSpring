package com.pizzaapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order1")
public class Order {

	  @Column(name="ordertype")
      private String orderType;
	  @Id
	  @SequenceGenerator(name = "order", sequenceName = "order_sequence", initialValue = 50000, allocationSize = 1)
      @GeneratedValue(generator = "order", strategy = GenerationType.SEQUENCE)  	  
	  @Column(name="orderid")
      private int orderId;
	  @Column(name="orderdescription")
      private String orderDescription;
	  @Column(name="ordercustomerid")
	  private int orderCustomerId;
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
	public int getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<PizzaOrder> pizzaOrders = new HashSet<>();
	
	public Order(String orderType, String orderDescription, int orderCustomerId) {
		this.orderType = orderType;
		this.orderDescription = orderDescription;
		this.orderCustomerId = orderCustomerId;
	}
	public Order() {
	
	}

	
	

}