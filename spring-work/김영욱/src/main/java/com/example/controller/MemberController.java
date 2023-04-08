package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		String mesg = "사용가능";
		
		int check = memberService.idCheck(userid);
		if (check==0) mesg="사용불가";
		
		System.out.println("확인용 : "+check+" "+"mesg");
		
		return mesg;		
	}
	
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public ModelAndView memberAdd(@ModelAttribute MemberDTO member, @RequestParam("passwdConfirm")String passwdConfirm){
		
		ModelAndView mav = new ModelAndView();
		try {
			int check = memberService.memberAdd(member, passwdConfirm);
			if (check==1)
			{
				mav.addObject("action","회원가입");
				mav.addObject("message","회원가입 성공");
				mav.setViewName("memberResult");
			}
			else
			{
				mav.addObject("message","회원가입 실패");
				mav.setViewName("memberResult");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("index");
		}
		return mav;
		
	}
	
//	@PostMapping("/login")
//	public ModelAndView loginPost(@RequestParam("userid")String userid,@RequestParam("passwd")String passwd) {
//		ModelAndView mav = new ModelAndView();
//		
//		try {
//	        HashMap<String, String> map = new HashMap<>();
//	        map.put("passwd", passwd);
//	        map.put("userid", userid);
//	        memberService.login(map);
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//			
//		}
//	}

	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public String memberUpdate() {
		
		/* 
		 * 
		 */
		
		return "memberResult";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {		
		
		/* 
		 * 
		 */
		
		return "mypage";  
	}		
	

}