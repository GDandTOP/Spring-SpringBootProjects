package com.kr.bank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kr.bank.dao.AccountDAO;
import com.kr.bank.dto.Account;
import com.kr.bank.service.IAccountService;




@Controller
public class AccountController {
	
	@Autowired
	AccountDAO accountDAO;
	
	
	@Autowired
	IAccountService accountService;

	@GetMapping("/")
	public String main() {
		return "bankmain";
	}
	@GetMapping("/allAccountInfo")
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Account> accs = accountDAO.selectAllAccount();
			mav.addObject("accs", accs);
			mav.setViewName("allAccountInfo");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "전체 계좌 조회 실패");
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
			System.out.println("하이");
			accountService.makeAccount(acc);
			mav.addObject("id", acc.getId());
			mav.setViewName("makeaccount_success");
		} catch(Exception e) {
			mav.addObject("err","계좌 개설 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@ResponseBody
	@PostMapping("/doubleid")
	public ResponseEntity<Boolean> doubleId(@RequestParam("id") String id) {
		ResponseEntity<Boolean> res = null;
		try {
			res= new ResponseEntity<Boolean>(
					accountService.doubleId(id),HttpStatus.OK
					);
					
		} catch(Exception e) {
			e.printStackTrace();
			res= new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return res;
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}	
	
	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountService.selectAccount(id);
			if(acc==null) throw new Exception("계좌번호 오류 boot ver.");
			acc.deposit(money);
			accountService.updateBalance(acc);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "입금 실패");
			mav.setViewName("error");
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
			Account acc = accountService.selectAccount(id);
			if(acc==null) throw new Exception("계좌번호 오류");
			acc.withdraw(money);
			HashMap<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("balance", acc.getBalance());
			accountService.updateBalance2(param);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "출금실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/accountInfo")
	public String accountinfo() {
		return "accountInfo";
	}	
	

	@PostMapping("/accountInfo")
	public String accountinfo(@RequestParam("id") String id, Model model) {
		try {
			Account acc = accountService.selectAccount(id);
			model.addAttribute("acc", acc);
			return "accountinfo_success";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err", "계좌 조회 실패 boot ver.");
			return "error";
		}
	}	
	
}
