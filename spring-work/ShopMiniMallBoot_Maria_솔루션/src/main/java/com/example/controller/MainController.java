package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model m) {
		return "index";   //index.jsp
	}
	
	@GetMapping("/main")
	public String goods(Model model) {
		
		
		return "shopMain";   //goodsList.jsp
	}
}

