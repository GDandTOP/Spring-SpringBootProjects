package com.example.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.CartDTO;
import com.example.dto.GoodsDTO;
import com.example.dto.MemberDTO;
import com.example.dto.OrderDTO;
import com.example.service.CartService;
import com.example.service.GoodsService;
import com.example.service.MemberService;

@Controller
public class GoodsController {

	@Autowired
	CartService cartService;

	
	
	@RequestMapping("/cartOrderAllDone")//카트 번호를 이용한 다건 결제 처리
	public String cartOrderAllDone(HttpServletRequest request,
			HttpSession session, Model m) {
		
		/*
		 * 
		 * 
		 * 
		 */
		
		return "orderAllDone";
	}

	@RequestMapping("/cartOrderAllConfirm")//카트 상품, 선택된 모든 카트번호를 이용한 다건 주문
	public String cartOrderAllConfirm(HttpServletRequest request, HttpSession session, Model m) {
		String[] checks = request.getParameterValues("check");
		
		/*
		 * 
		 * 
		 * 
		 */
		
		return "orderAllConfirm";
	}

	@RequestMapping("/cartOrderDone")//카트 번호를 이용한 단건 결제 처리
	public String cartOrderDone(OrderDTO oDTO, HttpSession session, @RequestParam(required = false) String orderNum) {
		
		/*
		 * 
		 * 
		 * 
		 */
		return "orderDone";
	}

	@RequestMapping("/cartOrderConfirm")//카트 상품 주문, 카트번호를 이용한 단건 주문
	public ModelAndView cartOrderConfirm(@RequestParam(required = false)  String num) {
		ModelAndView mav = new ModelAndView();
		
		/*
		 * 
		 * 
		 * 
		 */

		return mav;
	}
	
	@RequestMapping("/orderConfirm")//상품 상세에서 바로 주문, 카트 번호 미이용 단건 주문
	public ModelAndView orderConfirm(GoodsDTO gDTO,
									@RequestParam("gSize") String gSize,
									@RequestParam("gColor") String gColor,
									@RequestParam("gAmount") String gAmount){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("gSize", gSize);
		mav.addObject("gColor", gColor);
		mav.addObject("gAmount", gAmount);				
		mav.addObject("gDTO", gDTO);
		
		mav.setViewName("orderConfirm");
		
		return mav;
	}

	@RequestMapping("/CartDelAll")//카트 모든 상품 삭제
	public String CartDelAll(HttpServletRequest request) {		
		/*
		 * 
		 * 
		 * 
		 */
		return "redirect:/cartList";
	}

	@RequestMapping("/cartDelete")//카트 개별 상품 삭제
	@ResponseBody
	public void cartDelete(@RequestParam("num") int num) {
		cartService.cartDel(num);
	}

	@RequestMapping("/cartUpdate")//카트 개별 상품 수량 변경
	@ResponseBody
	public void cartUpdate(@RequestParam Map<String, Integer> map) {
		cartService.cartUpdate(map);
	}

	@RequestMapping("/cartList")
	public String cartList(HttpSession session, Model m) {
		String page = "redirect:/";

		/*
		 * 
		 * 
		 * 
		 */
		return page;
	}

	@RequestMapping("/addCart")
	public String goodsCart(CartDTO cDTO, HttpSession session, Model m) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("user");
		String page = "redirect:/";
		if (mDTO != null) {
			cDTO.setUserid(mDTO.getUserid());
			cartService.cartAdd(cDTO);
			page = "redirect:/goodsRetrieve?gCode=" + cDTO.getgCode()+"&cart=Y";
		}
		return page;
	}

	@RequestMapping("/goodsList")
	public String goodsList(@RequestParam(value = "gCategory", required = false, defaultValue = "top")
							String gCategory,
							Model m) {
		/*
		 * 
		 * 
		 * 
		 */
		return "main";
	}

	@RequestMapping("/goodsRetrieve") 
	@ModelAttribute("item")  
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
		/*
		 * 
		 * 
		 * 
		 */
		return null;
	}

}
