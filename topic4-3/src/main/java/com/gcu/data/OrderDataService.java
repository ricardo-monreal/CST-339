package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>{
	
	
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	// non-default constructor for constructor injection
	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
		this.ordersRepository = ordersRepository;
	}
	
	
	
	//CRUD: finder to return all entities
	@Override
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
	@Override
	public boolean create(OrderEntity order) {
		
		//Example of "overriding" the CRUD Repository save() because it simply never called
				//You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
				String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
				
				try {
					//Execute SQL Insert
					jdbcTemplateObject.update(sql,
							                  order.getOrderNo(),
							                  order.getProductName(),
							                  order.getPrice(),
							                  order.getQuantity());
				}
				catch (Exception e) {
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



	@Override
	public OrderEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
