package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@GetMapping("/")
	@ResponseBody
	public ModelAndView printHome()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", new String("Welcome to CST-339 Topic 2 Activity"));
		
		mv.setViewName("home");
		return mv;
		
	}

}
