package com.kt.bank.dao;

import java.util.HashMap;
import java.util.List;

import com.kt.bank.dto.Account;

public interface AccountDAO {
	void insertAccount(Account acc) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateBalance(Account acc) throws Exception;
	void updateBalance2(HashMap<String,Object> param) throws Exception;
	List<Account> selectAllAccount() throws Exception;
}	
