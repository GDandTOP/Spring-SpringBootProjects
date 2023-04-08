package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model m) {
		return "index";   
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		
		return "shopMain"; 
	}
}

