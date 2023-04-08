package com.kr.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.kr.bank.dto.Member;
import com.kr.bank.service.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;

	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute Member member, Model model) {
		try {
			memberService.insertMember(member);
			return "login";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err", "회원가입 실패");
			return "error";
		}
	}	

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id, 
			@RequestParam("password") String password,
			Model model) {
		try {
			Member member = memberService.selectMember(id);
			if(member!=null && member.getPassword().equals(password)) {
				session.setAttribute("id", id);
				return "makeAccount";
			} else {
				throw new Exception("로그인 실패");
			}
		} catch(Exception e) { 
			e.printStackTrace();
			model.addAttribute("err", "로그인 실패");
			return "error";			
		}
	}	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout() {
		session.removeAttribute("id");
		return "login";
	}
}
