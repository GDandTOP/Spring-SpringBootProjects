package com.kr.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.bank.entity.Account;
import com.kr.bank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public Account accountInfo(String id) throws Exception {
		Optional<Account> oacc = accountRepository.findById(id);
		Account acc = null;
		if(oacc.isPresent()) {
			acc = oacc.get();
		}
		return acc;
	}
	
	public void makeAccount(Account acc) throws Exception {
		accountRepository.save(acc);
	}
	
	public Account deposit(String id, Integer money) throws Exception {
		Optional<Account> oacc = accountRepository.findById(id);
		if(oacc.isEmpty()) throw new Exception("계좌번호 오류");
		Account acc = oacc.get();
		acc.deposit(money);
		accountRepository.save(acc);
		return acc;
	}
	
	public Account withdraw(String id, Integer money) throws Exception {
		Optional<Account> oacc = accountRepository.findById(id);
		if(oacc.isEmpty()) throw new Exception("계좌번호 오류");
		Account acc = oacc.get();
		acc.withdraw(money);
		accountRepository.save(acc);
		return acc;
	}
	
	public List<Account> allAccountInfo() throws Exception {
		return accountRepository.findAll();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void trasnfer(String sid, String rid, Integer money) throws Exception {
		if(accountRepository.updateWithdraw(sid, money)==0) throw new Exception();
		if(accountRepository.updateDeposit(rid, money)==0) throw new Exception();
	}
}
