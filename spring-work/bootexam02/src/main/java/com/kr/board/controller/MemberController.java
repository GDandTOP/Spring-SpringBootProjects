package com.kr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kr.board.entity.Member;
import com.kr.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/memberAdd")
	public String memberAdd() {
		return "memberForm";
	}
	
	@PostMapping("/memberAdd")
	public ModelAndView join(@ModelAttribute Member member) {
		ModelAndView mav = new ModelAndView();
		try {
			memberService.join(member);
			mav.setViewName("redirect:/home");
			
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userid")String id, @RequestParam("passwd")String password) {
		try {
			memberService.login(id, password);
			return "index";
			
		} catch (Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		try {
			memberService.logout();
			return "index";
		} catch(Exception e ) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/mypage")
	public ModelAndView mypage() {
		ModelAndView mv = new ModelAndView();
		try {
			Member member = memberService.mypage();
			mv.addObject("member", member);
			mv.setViewName("mypage");
		} catch(Exception e) {
			e.printStackTrace();
			mv.setViewName("error");
		}
		
		return mv;
	}
	
	@PostMapping("/doubleid")
	@ResponseBody
	public ResponseEntity<Boolean> doubleId(@RequestParam("id") String id) {
		ResponseEntity<Boolean> res = null;
		try {
			Boolean isdouble = memberService.doubleId(id);
			res = new ResponseEntity<Boolean>(isdouble, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return res;
	}	
	
	



}
