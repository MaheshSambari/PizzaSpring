package com.pizzaapplication.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pizzaapplication.entity.Customer;
import com.pizzaapplication.entity.LineItem;
import com.pizzaapplication.entity.Order;
import com.pizzaapplication.entity.Pizza;
import com.pizzaapplication.entity.PizzaOrder;
import com.pizzaapplication.entity.PlaceOrder;
import com.pizzaapplication.exception.CustomerNotFoundException;
import com.pizzaapplication.exception.CustomerOrderException;
import com.pizzaapplication.exception.PizzaNotFoundException;
import com.pizzaapplication.exception.PizzaOrderException;
import com.pizzaapplication.exception.PizzaOutOfStock;
import com.pizzaapplication.repository.CustomerRepository;
import com.pizzaapplication.repository.LineItemRepository;
import com.pizzaapplication.repository.OrderRepository;
import com.pizzaapplication.repository.PizzaOrderRepository;
import com.pizzaapplication.repository.PizzaRepository;

@Service
@Transactional
public class PizzaOrderServiceImpl implements PizzaOrderService {
	@Autowired
	private PizzaOrderRepository repository;
	@Autowired
	private PizzaRepository pizzaRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired 
	private LineItemRepository cartRepository;	


	@Override
	public List<PizzaOrder> getAllPizzaOrders() {
		return repository.findAll();
	}

	@Override
	public List<PizzaOrder> getPizzaOrderByDate(LocalDate orderDate) throws PizzaOrderException {
		List<PizzaOrder> p = repository.findByDate(orderDate);
		if(p.size()!=0) {
			return p;
		}
		else {throw new PizzaOrderException(orderDate);}
	}

	@Override
	public List<PizzaOrder> getPizzaOrderById(int orderId) throws PizzaOrderException {
		List<PizzaOrder> p = repository.findById1(orderId);
		if(p.size()!=0) {
			return p;
		}
		else {throw new PizzaOrderException(orderId);}
	}

	@Override
	public List<PizzaOrder> getPizzaOrderByCustomerId(int customerId) throws CustomerOrderException {
		List<PizzaOrder> p = repository.findByCustomerId1(customerId);
		if(p.size()!=0) {
			return p;
		}
		else {throw new CustomerOrderException(customerId);}
	}

	
	
	@Override
	public String deletePizzaOrderById(int pizzaorderId) throws PizzaOrderException{
		
		Optional<PizzaOrder> p = repository.findById(pizzaorderId);
		if(p.isPresent()) {
			repository.deleteById1(pizzaorderId);
			return "you are Succesfully deleted  Order";
		}
		else {throw new PizzaOrderException(pizzaorderId);}	}

	
	@Override
	public String orderPizza(PlaceOrder p) throws CustomerNotFoundException,PizzaNotFoundException,PizzaOutOfStock  {
		double totalCost = 0.0 ;
		Set<PizzaOrder> pizzaOrders = new HashSet<>();
		Optional<Customer> cust = customerRepository.findById(p.getOrderCustomerId());
		Customer customer;
		if(cust.isPresent())
		{	
			customer=cust.get();
			Order order=new Order();
			order.setOrderDescription(p.getOrderDescription());
			order.setOrderCustomerId(customer);
			order.setOrderLocation(p.getOrderLocation());
			List<LineItem> list = cartRepository.findByCustomerId(p.getOrderCustomerId());

			if(list.size()!=0) {
				int a = Available(list);
				if(a==1) {
					for (LineItem lineItem : list) {
						Optional<Pizza> p1 = pizzaRepository.findById(lineItem.getPizzaId());
						Pizza p2=p1.get();
						p2.setAvailableQuantity(p2.getAvailableQuantity()-lineItem.getQuantity());
						totalCost =+ lineItem.getTotalAmount();
						PizzaOrder po = new PizzaOrder();
						po.setPizza(p2);
						po.setQuantity(lineItem.getQuantity());
						po.setSize(lineItem.getSize());
						po.setTotalCost(totalCost);
						po.setOrderDate(LocalDate.now());
						po.setOrder(order);
						po.setTransactionMode(p.getTransactionMode());
						pizzaOrders.add(po);
						cartRepository.deleteByCustomerId(p.getOrderCustomerId());
					}
					order.setPizzaOrders(pizzaOrders);
					double orderAmount=0.0;
					for(PizzaOrder p3 : pizzaOrders ) {
						orderAmount = orderAmount+p3.getTotalCost();	
					}
					orderAmount = Math.floor(orderAmount*100)/100;
					order.setOrderAmount(orderAmount);
					orderRepository.save(order);
					return "Your Order Succesfully Placed with Id "+ order.getOrderId() + " Your Order Total Amount Is "+ order.getOrderAmount();
				}
				else { throw new PizzaOutOfStock();}
			}
			else { throw new CustomerNotFoundException();}
		}
		else { throw new CustomerNotFoundException(p.getOrderCustomerId());}
	}


	
	public int Available(List<LineItem> list) {
		int i=0;
		for (LineItem lineItem : list) {
			Optional<Pizza> p1 = pizzaRepository.findById(lineItem.getPizzaId());
			Pizza p2=p1.get();
			if(p2.getAvailableQuantity()>=lineItem.getQuantity()) {
				i=i+1; 
			}
		}
		if(i==list.size()) {return 1;}

		else return 0;

	}

}
