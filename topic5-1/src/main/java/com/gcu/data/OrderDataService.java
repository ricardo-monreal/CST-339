package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>{
	
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	// non-default constructor for constructor injection
	public OrderDataService(OrdersRepository ordersRepository) {
		
		
		this.ordersRepository = ordersRepository;
	}
	
	//CRUD: finder to return a single entity
	public OrderEntity findById(int id) {
		
		return null;
	}
	
	//CRUD: finder to return all entities
	public List<OrderEntity> findAll(){
		
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		try
		{
			//get all the entity orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return orders;
	}
	
	// CRUD: create an entity
	public boolean create(OrderEntity order) {
		
		try
		{
			this.ordersRepository.save(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
//	
//	public boolean update() {
//		
//		return true;
//	}
//	
//	public boolean delete() {
//		return true;
//	}

	// CRUD update an entity
	@Override
	public boolean update(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	// CRUD delete an entity
	@Override
	public boolean delete(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
