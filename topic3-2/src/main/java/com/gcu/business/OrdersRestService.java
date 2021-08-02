package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	@Autowired
	private OrdersBusinessInterface service;
	
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> gerOrdersAsJson()
	{
		return service.getOrders();
	}
	
	
	@RequestMapping(path="/getxml", produces = { MediaType.APPLICATION_XML_VALUE } )
	
	//@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
	
	
}


