package com.kt.bank.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kt.bank.dto.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	}

	@Override
	public void insertAccount(Account acc) throws Exception {
		sqlSession.insert("mapper.account.insertAccount", acc);
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		return sqlSession.selectOne("mapper.account.selectAccount", id);
	}

	@Override
	public void updateBalance(Account acc) throws Exception {
		sqlSession.update("mapper.account.updateBalance", acc);
		
	}

	@Override
	public void updateBalance2(HashMap<String, Object> param) throws Exception {
		sqlSession.update("mapper.account.updateBalance2", param);		
	}

	@Override
	public List<Account> selectAllAccount() throws Exception {
		return sqlSession.selectList("mapper.account.selectAllAccount");
	}
}
