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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pizza")
public class Pizza {

	
	@Column(name="pizzaid")
	@Id
	@SequenceGenerator(name = "pizza", sequenceName = "pizza_sequence", initialValue = 30000, allocationSize = 1)
    @GeneratedValue(generator = "pizza", strategy = GenerationType.SEQUENCE)  	
	private int pizzaId;
	@Column(name="pizzatype")
	@NotNull(message = "Pizza type not to be empty")
	private String pizzaType;
	@Column(name="pizzaname")
	@NotNull(message = "Pizza name not to be empty")
	private String pizzaName;
	@Column(name="pizzadescription")
	@NotNull(message = "pizza Description not to be empty")
	private String pizzaDescription;
	@Column(name="pizzacost")
	@Min (message = "pizza Cost not to be empty", value = 50)
	private double pizzaCost;

	
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	@OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private Set<PizzaOrder> pizzaOrders = new HashSet<>();


	public Pizza(@NotNull(message = "Pizza type not to be empty") String pizzaType,
			@NotNull(message = "Pizza name not to be empty") String pizzaName,
			@NotNull(message = "pizza Description not to be empty") String pizzaDescription,
			@Min(message = "pizza Cost not to be empty", value = 50) double pizzaCost) {
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
	}
	public Pizza() {
	}
	

}

