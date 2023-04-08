package com.kr.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kr.bank.entity.Account;
import com.kr.bank.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/accountInfo")
	public String accountInfo() {
		return "accountInfo";
	}
	
	@PostMapping("/accountInfo")
	public ModelAndView accountInfo(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "계좌 조회 오류");
			mav.setViewName("error");			
		}
		return mav;
	}
	
	@GetMapping("/makeAccount")
	public String makeAccount() {
		return "makeAccount";
	}

	@PostMapping("/makeAccount")
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.makeAccount(acc);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			mav.addObject("err", "계좌 개설 오류");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountService.deposit(id,money);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			mav.addObject("err", "입금 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public ModelAndView withdraw(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountService.withdraw(id, money);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "출금 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/allAccountInfo")
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Account> accs = accountService.allAccountInfo();
			mav.addObject("accs", accs);
			mav.setViewName("allAccountInfo");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "전체 계좌 조회 오류");
			mav.setViewName("error");
		}
		return mav;
	}
}
