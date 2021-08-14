package com.gcu.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;





@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private OrdersBusinessInterface service;
	
	//Inject and autowire the Security Business Service into the Login Controller
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model) 
	{
		// Display login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		return "login";
		
	}
	
	
	
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		service.test();
		//Make a call to the service authenticate() method
		security.authenticate(null, null);
		
		System.out.println(String.format("Form with username of %s and password of %s ", loginModel.getUsername(), loginModel.getPassword()));
		
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		
		
		
		service.getOrders();
		
		
		
		// display the Orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		return "orders";
	}











	

	
	
	
	


	






	
	
	
	
	

}
