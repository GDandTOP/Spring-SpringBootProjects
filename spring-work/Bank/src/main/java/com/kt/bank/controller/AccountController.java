package com.kt.bank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kt.bank.dao.AccountDAO;
import com.kt.bank.dto.Account;


@Controller
public class AccountController {
	
	@Autowired // 사용하기 위해
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "bankmain";
	}
	
	@RequestMapping(value="/makeAccount", method=RequestMethod.GET)
	public String makeAccount() {
		return "makeAccount";
	}
	
	@RequestMapping(value="/makeAccount", method=RequestMethod.POST)
	public String makeAccount(@ModelAttribute Account acc, Model model) {
		try {
			accountDAO.insertAccount(acc);
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("id",acc.getId());
		
		return "makeaccount_success";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountDAO.selectAccount(id);
			
			acc.deposit(money);
			System.out.println("비포"+acc.getBalance());
			accountDAO.updateBalance(acc);
			
			System.out.println("애프터1"+acc.getBalance());
			mav.addObject("acc",acc);
			System.out.println("애프터2"+acc.getBalance());
			mav.setViewName("accountinfo_success");
			System.out.println("애프터3"+acc.getBalance());
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","입금 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam("id") String id, @RequestParam("money") Integer money)  {
		ModelAndView mav= new ModelAndView();
		try {
			Account acc = accountDAO.selectAccount(id);
			if(acc==null) throw new Exception("계좌번호 오류");
			acc.withdraw(money);
			HashMap<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("balance", acc.getBalance());
			accountDAO.updateBalance2(param);
			mav.addObject("acc",acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","출금실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/accountInfo", method=RequestMethod.GET)
	public String accountInfo() {
		return "accountInfo2";
	}
	
	@RequestMapping(value="/allAccountInfo", method=RequestMethod.GET)
	public ModelAndView allAccuntInfo() {
		ModelAndView mav = new ModelAndView();
		try {

			List<Account> accs = accountDAO.selectAllAccount();

		
			mav.addObject("accs",accs);

			mav.setViewName("allAccountInfo");

		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","전체 계좌 조회 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@ResponseBody
	@PostMapping("/doubleid")
	public ResponseEntity<String> doubleId(@RequestParam("id") String id) {
		ResponseEntity<String> res=null;
		try {
			Account acc = accountDAO.selectAccount(id);
			if (acc!=null) {
				return new ResponseEntity<String>("true",HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("false", HttpStatus.OK);
			}
		} catch(Exception e) {
			e.printStackTrace();
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value="/AccountInfo", method=RequestMethod.POST)
	public String accountInfo(@RequestParam("id") String id, Model model) {
		try {
			Account acc = accountDAO.selectAccount(id);
			model.addAttribute("acc",acc);
			return "accountinfo_success";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","계좌 조회 실패");
			return "error";
		}	
	}
	
	@RequestMapping(value="/AccountInfo2", method=RequestMethod.POST)
	public ResponseEntity<Account> accountInfo2(@RequestParam("id") String id, Model model) {
		try {
			Account acc = accountDAO.selectAccount(id);
			if (acc!=null) {
				return new ResponseEntity<Account>(acc,HttpStatus.OK);
			} else throw new Exception("계좌번호 오류");
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}	
	}
	

	
}
