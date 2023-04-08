package com.kr.bank.service;

import java.util.HashMap;
import java.util.List;

import com.kr.bank.dto.Account;
import com.kr.bank.dto.Member;

public interface IMemberService {

	void insertMember(Member member) throws Exception;

	Member selectMember(String id);


}
