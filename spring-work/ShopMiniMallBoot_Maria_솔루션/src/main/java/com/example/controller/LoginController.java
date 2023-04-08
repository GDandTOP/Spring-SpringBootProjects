package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;



@Controller
public class LoginController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, 
			            Model model,
			            HttpSession session) throws Exception{
		
		MemberDTO dto = memberService.login(map);
		//List<GoodsDTO> goods = null; //goodsService.goodsList();
		System.out.println(dto);
		// id와 pw 모두 일치한 경우: dto에 id에 해당정보 저장
		// id와 pw  일치하지 않는 경우: dto에 null
		String page = "";
		if(dto==null) {
			//로그인 실패
			model.addAttribute("action", "로그인");
			model.addAttribute("message", "로그인 실패");
			page = "memberResult";
		}else {
			//로그인 성공==> HttpSession에 데이터저장
			session.setAttribute("user", dto);
			//goods = goodsService.goodsList();
			//model.addAttribute("goods", goods);
			page = "redirect:/main";  // goods.jsp
			System.out.println("간다...");
		}		
		return page; 
	}//
	
	@RequestMapping("/logout")
	public String logout(HttpSession session ) throws Exception{
		session.invalidate();  		
		return "redirect:/";
	}
	
	@ExceptionHandler({Exception.class})
	public String errorPage() {
		return "error";
	}
}





