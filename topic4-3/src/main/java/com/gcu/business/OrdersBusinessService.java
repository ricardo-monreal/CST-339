package com.gcu.business;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

@Component
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	
	@Autowired
	OrderDataService service;
	
	@Bean
	public void test() {
		// print to the console 
		System.out.println("Hello from the OrdersBusinessService");
		
	}
	
	public List<OrderModel> getOrders() {
		//create some orders
//		ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
//		//List<OrderModel> orders = new ArrayList<OrderModel>();
//		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
//		orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 1));
//		orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 1));
//		orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 1));
//		orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 1));
//		//orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
//		return orders;
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
		
		
		
		
		
	}
	//Implement the init() and destroy() methods
	@PostConstruct
	public void init() {
		System.out.println("init() method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy() method");
	}
	
			
	
}
