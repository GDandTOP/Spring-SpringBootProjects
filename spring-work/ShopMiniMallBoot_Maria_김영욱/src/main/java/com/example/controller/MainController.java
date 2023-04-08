package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.GoodsDTO;
import com.example.service.GoodsService;

@Controller
public class MainController {

	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/")
	public String main(Model m) {
		return "index";   //index.jsp
	}
	
	@GetMapping("/main")
	public ModelAndView goods(Model model) {
		ModelAndView mav = new ModelAndView();
		try {
			List<GoodsDTO> goodsList = goodsService.goodsList();
			System.out.println("goodslist: "+goodsList);
			mav.addObject("goods",goodsList);
			mav.setViewName("shopMain");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			mav.setViewName("shopMain");
		}
		return mav;
		
	}
}

