package com.gcu.business;




import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessInterface {
	
	public void test();
	
	public List<OrderModel> getOrders();
	
	//Update the OrdersBusinessServiceInterface class by adding a new method public OrderModel getOrderById(String id) declaration.
	public OrderModel getOrderById(String id);
	
	public void init();
	
	public void destroy();
	
	

}
