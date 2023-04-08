package com.kt.bank.dao;

import java.util.HashMap;
import java.util.List;

import com.kt.bank.dto.Account;
import com.kt.bank.dto.Member;

public interface MemberDAO {
	void joinMember(Member member) throws Exception;

	Member loginMember(String id) throws Exception;

}	
