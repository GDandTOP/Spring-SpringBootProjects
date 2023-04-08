package com.kr.bank.controller;

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

import com.kr.bank.entity.Member;
import com.kr.bank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/join")
	public String join() {
		return "join";
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
	
	@PostMapping("/join")
	public String join(@ModelAttribute Member member) {
		try {
			memberService.join(member);
			return "login";
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}	
	
	@PostMapping("/login") 
	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
		try {
			memberService.login(id,password);
			return "main";
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		try {
			memberService.logout();
			return "main";
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
		} catch(Exception e) {
			e.printStackTrace();
			mv.setViewName("error");
		}
		
		return mv;
	}
}
