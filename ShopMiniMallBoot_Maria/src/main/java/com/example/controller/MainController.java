//ShopMiniMall 서블릿 버전의 MainServlet 역할

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.GoodsDTO;
import com.example.service.GoodsService;

@Controller
public class MainController {

	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/main")
	public String goods(Model model) {		
		/*
		 * 
		 * 
		 * 
		 */
		return "shopMain";   
	}
	@RequestMapping("/")
	public String main(Model m) {
		return "index";   
	}
}
