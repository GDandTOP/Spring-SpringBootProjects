package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/signUp")
	public String loginUI() {
		return "signUpForm";		
	}
	
	@RequestMapping(value="/idCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody 
	public String idCheck(@RequestParam("id") String userid,
			@RequestParam("pw") String pw) {
		int result = memberService.idCheck(userid); 
		String mesg = "사용가능";
		if(result==1) {
			mesg = "사용불가";
		}
		
		return mesg;		
	}
	
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String memberAdd(MemberDTO dto, Model model) {
		System.out.println(dto);
		int n = 0;
		try {
			n = memberService.memberAdd(dto);
		}catch(Exception e) {			
		}
		model.addAttribute("action", "회원가입");
		if(n==1) {
			model.addAttribute("message", "회원가입 성공");
		}else {
			model.addAttribute("message", "회원가입 실패");  //컬럼 값이 너무 크거나 하는 경우 오류발생 처리
		}		
		return "memberResult";
	}

	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public String memberUpdate(MemberDTO dto, Model model) {
		System.out.println(dto);
		int n = 0;
		try {
			n = memberService.memberUpdate(dto);
		} catch (Exception e) {

		}
		model.addAttribute("action", "회원정보수정");
		if (n == 1) {
			model.addAttribute("message", "회원정보수정 성공");
		} else {
			model.addAttribute("message", "회원정보수정 실패");  //컬럼 값이 너무 크거나 하는 경우 오류발생 처리
		}		
		return "memberResult";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {		
		MemberDTO mDTO = (MemberDTO)session.getAttribute("user");		
		MemberDTO dto = memberService.mypage(mDTO.getUserid());
		session.setAttribute("user", dto);		
		return "mypage";  //mypage.jsp
	}		
}