package com.gcu.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gcu.model.OrderModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/app")
public class TestController {
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		// display the home page
		model.addAttribute("title", "Demo Microservices Application");
		return "home";
	}

	@GetMapping("/getusers")
	public String getUsers(Model model)
	{
		// create the REST API end point URL
		String hostname = "localhost";
		int port = 8081;
		
		// get all the Users from the REST API
		String url = "http://" + hostname + ":" + port + "/service/users";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<UserModel>> rateResponse = restTemplate.exchange(url,  HttpMethod.GET, null, new ParameterizedTypeReference<List<UserModel>>() {});
		List<UserModel> users = rateResponse.getBody();
		
		// display the users
		model.addAttribute("title", "List of Users");
		model.addAttribute("users", users);
		return "users";
		
	}
	
	
	@GetMapping("/getorders")
	public String getOrders(Model model)
	{
		// create the REST API end point URL
		String hostname = "localhost";
		int port = 8082;
		
		// get all the orders from the REST API
		String url = "http://" + hostname + ":" + port + "/service/orders";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<OrderModel>> rateResponse = restTemplate.exchange(url,  HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderModel>>() {});
		List<OrderModel> orders = rateResponse.getBody();
		
		// display the orders
		model.addAttribute("title", "List of Orders");
		model.addAttribute("orders", orders);
		return "orders";
	}
	
}
