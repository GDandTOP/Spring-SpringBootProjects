package com.kr.bank.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kr.bank.dto.Account;

@Repository
@Mapper
public interface AccountDAO {
	void insertAccount(Account acc) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateBalance(Account acc) throws Exception;
	void updateBalance2(HashMap<String, Object> param) throws Exception;
	List<Account> selectAllAccount() throws Exception;
}
