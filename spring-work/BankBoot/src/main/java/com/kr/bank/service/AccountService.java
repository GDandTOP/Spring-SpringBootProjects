package com.kr.bank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.bank.dao.AccountDAO;
import com.kr.bank.dto.Account;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	AccountDAO accountDAO;
	
	
	@Override
	public List<Account> accountList() throws Exception {
		return accountDAO.selectAllAccount();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDAO.insertAccount(acc);
	}
	
	@Override
	public Boolean doubleId(String id) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc==null) return false;
		return true;
	}
	
	@Override
	public Account selectAccount(String id) throws Exception {
		return accountDAO.selectAccount(id);
	}
	
	@Override
	public void updateBalance(Account acc) throws Exception {
		accountDAO.updateBalance(acc);
	}
	
	@Override
	public void updateBalance2(HashMap<String, Object> param) throws Exception {
		accountDAO.updateBalance2(param);		
	}
}
