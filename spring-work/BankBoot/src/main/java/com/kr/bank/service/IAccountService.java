package com.kr.bank.service;

import java.util.HashMap;
import java.util.List;

import com.kr.bank.dto.Account;

public interface IAccountService {
	void makeAccount(Account acc) throws Exception;
	List<Account> accountList() throws Exception;
	Boolean doubleId(String id) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateBalance(Account acc) throws Exception;
	void updateBalance2(HashMap<String, Object> param) throws Exception;


}
