package com.gcu.business;

import java.util.ArrayList;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.model.OrderModel;

@Component
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	@Bean
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println("Hello from the AnotherOrdersBusinessService");
		
	}
	
	public ArrayList<OrderModel> getOrders() {
		
		ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
		//List<OrderModel> orders = new ArrayList<OrderModel>();
//		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
//		orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 1));
//		orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 1));
//		orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 1));
//		orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 1));
		//orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		
		
		return orders;
	}
	
	//Implement the init() and destroy() methods
	@PostConstruct
	public void init() {
		System.out.println("Another init() method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Another Destroy() method");
	
	}

	//Update the AnotherOrdersBusinessService class by implementing the getOrderById() method. The implementation can simply return null.
	@Override
	public OrderModel getOrderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
