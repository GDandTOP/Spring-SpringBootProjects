package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		String page = "";
	
		page="index";
		
		return page; 
	}//
	

	
	
	@RequestMapping("/logout")
	public String logout() {
		
		/*
		 * 
		 * 
		 */
				
		return "redirect:/";
	}
	
}





