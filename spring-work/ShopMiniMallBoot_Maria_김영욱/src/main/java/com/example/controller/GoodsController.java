package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.CartDTO;
import com.example.dto.GoodsDTO;
import com.example.dto.MemberDTO;
import com.example.dto.OrderDTO;
import com.example.service.CartService;
import com.example.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	CartService cartService;
	
	@Autowired
	GoodsService goodsService;

	
	
	@RequestMapping("/cartOrderAllDone")//카트 번호를 이용한 다건 결제 처리
	public String cartOrderAllDone(HttpServletRequest request,
			HttpSession session, Model m) {
		
		List<CartDTO> goods = new ArrayList <CartDTO>();
		List<String> nums = Arrays.asList(request.getParameterValues("num"));
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedNow = now.format(formatter); 
		for(String i:nums) {
			goods.add(cartService.cartbyNum(i));
		}
		
		MemberDTO mDTO = (MemberDTO) session.getAttribute("user");
		
		List<OrderDTO> orders = new ArrayList <OrderDTO>();
		
		for(CartDTO c:goods) {
			OrderDTO order=new OrderDTO(0, mDTO.getUserid(), c.getgCode(), c.getgName(),
					c.getgPrice(), c.getgSize(), c.getgColor(), c.getgAmount(),
					c.getgImage(), mDTO.getUsername(), mDTO.getPost(), mDTO.getAddr1(),
					mDTO.getAddr2(), mDTO.getPhone1()+"-"+mDTO.getPhone2()+"-"+mDTO.getPhone3(),
					request.getParameter("payMethod"), formattedNow);
			orders.add(order);
		}

		cartService.orderAllDone(orders, nums);
		m.addAttribute("orderAllDone", orders);
		return "orderAllDone";
	}

	@RequestMapping("/cartOrderAllConfirm")//카트 상품, 선택된 모든 카트번호를 이용한 다건 주문
	public String cartOrderAllConfirm(HttpServletRequest request, HttpSession session, Model m) {
		String[] checks = request.getParameterValues("check");
		System.out.println(checks.length);
		CartDTO[] cartList = new CartDTO[checks.length];
		for (int i=0; i<checks.length; i++) {
			cartList[i]= cartService.cartbyNum(checks[i]);
			System.out.println(cartList[i]);
		}
		
		m.addAttribute("cartList", cartList);
		
		return "orderAllConfirm";
	}

	@RequestMapping("/cartOrderDone")//카트 번호를 이용한 단건 결제 처리
	public String cartOrderDone(OrderDTO oDTO, HttpSession session, @RequestParam(required = false) String orderNum) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("user");
		if (mDTO != null) {
			oDTO.setUserid(mDTO.getUserid());
			cartService.orderDone(oDTO, orderNum);
		}
		return "orderDone";
	}

	@RequestMapping("/cartOrderConfirm")//카트 상품 주문, 카트번호를 이용한 단건 주문
	public ModelAndView cartOrderConfirm(@RequestParam(required = false)  String num) {
		System.out.println("num :"+num);
		
		ModelAndView mav = new ModelAndView();

		CartDTO[] cartList = new CartDTO[1];
		cartList[0]=cartService.cartbyNum(num);
		System.out.println(cartList+" "+cartService.cartbyNum(num));
		mav.addObject("cartList",cartList);
		mav.setViewName("orderAllConfirm");

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


	@ResponseBody
    @RequestMapping(value = "/CartDelAll", method = RequestMethod.POST)
	public int CartDelAll(HttpSession session,
	        @RequestParam(value="list[]") List<String> list) throws Exception {		
			cartService.cartAllDel(list);
			return 1;
	}

	@RequestMapping("/cartDelete")//카트 개별 상품 삭제
	@ResponseBody
	public void cartDelete(@RequestParam("num") int num) {
		cartService.cartDel(num);
	}

	@RequestMapping("/cartUpdate")//카트 개별 상품 수량 변경
	@ResponseBody
	public void cartUpdate(@RequestParam("num") String nums,@RequestParam("gAmount") String gAmounts) {

		Integer num = Integer.parseInt(nums);
		Integer gAmount = Integer.parseInt(gAmounts);
		HashMap<String,Integer> map = new HashMap<>();
		map.put("num", num);
		map.put("gAmount", gAmount);
		try {
			cartService.cartUpdate(map);

		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@RequestMapping("/cartList")
	public ModelAndView cartList(HttpSession session, Model m) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		
		try {

			List<CartDTO> cartList = cartService.cartList(mDTO.getUserid());

			mav.addObject("cartList",cartList);
			mav.setViewName("cartList");
			
		} catch(Exception e)
		{
			e.printStackTrace();
			mav.setViewName("cartList");
		}
		return mav;
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
	public ModelAndView goodsList(@RequestParam(value = "gCategory", required = false, defaultValue = "top")
							String gCategory,
							Model m) {
		ModelAndView mav = new ModelAndView();
		try {
			List<GoodsDTO> goodsList = goodsService.goodsList();

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

	@RequestMapping("/goodsRetrieve") 
	@ModelAttribute("item")  
	public ModelAndView goodsRetrieve(@RequestParam("gCode") String gCode) {
		GoodsDTO item = goodsService.goodsRetrieve(gCode);
		
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("item",item);
			mav.setViewName("goodsRetrieve");
		} catch (Exception e)
		{
			e.printStackTrace();
			mav.setViewName("goodsRetrieve");
		}
		
		return mav;
	}

}
