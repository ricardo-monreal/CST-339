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






@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String display(Model model) 
	{
		// Display login form view
		model.addAttribute("title", "Login Form");
		
		return "login";
		
	}
		
}
