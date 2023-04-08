package com.kt.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kt.bank.dao.MemberDAO;
import com.kt.bank.dto.Account;
import com.kt.bank.dto.Member;

@Controller
public class MemberController {
	
	@Autowired // 사용하기 위해 필수적으로 적용해야함
	private MemberDAO memberDAO;

	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String accountInfo(@RequestParam("id") String id,
			@RequestParam("password") String password,
			Model model) {
		try {
			Member member = memberDAO.loginMember(id);
			if (id.equals(member.getId())&&password.equals(member.getPassword())) {
				session.setAttribute("id",id);
				model.addAttribute("member",member);
				return "login_success";
			}
			else {
				model.addAttribute("err","로그인이 실패하였습니다. (계정 정보가 일치하지 않습니다.)");
				throw new Exception("로그인 실패");
			}

		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","로그인이 실패하였습니다. (계정 오류 발생)");
			return "error";
		}	
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		session.removeAttribute("id");
		return "login";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		System.out.println("조인");
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinMember(@ModelAttribute Member member, Model model) {
		try {
			System.out.println("가입 정보 : "+" "+member.getEmail()+" "+member.getId()+" "+member.getName()+" "+member.getGender()+" "+member.getAge());
			memberDAO.joinMember(member);
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("id",member.getId());
		
		return "makemember_success";
	}
}
