package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	// non-default constructor for constructor injection
	public OrdersBusinessService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	// get all orders from the database
	public List<OrderModel> getAllOrders(){
		
		// get all the entity orders
		List<OrderEntity> ordersEntity = ordersRepository.findAll();
		
		// iterate over the entity orders and create a list of domain orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity) 
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		// return list of domain orders
		return ordersDomain;
		
	}

}
