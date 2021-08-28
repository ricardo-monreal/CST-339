package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
@RequestMapping("/app")
public class TestController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
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
		// look up the hostname and port for the users REST API
		
		Application application = eurekaClient.getApplication("user-service");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		
	
		String hostname = instanceInfo.getHostName();
		int port = instanceInfo.getPort();
		
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
		// look up the hostname and port for the orders REST API
		Application application = eurekaClient.getApplication("order-service");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String hostname = instanceInfo.getHostName();
		int port = instanceInfo.getPort();
		
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
