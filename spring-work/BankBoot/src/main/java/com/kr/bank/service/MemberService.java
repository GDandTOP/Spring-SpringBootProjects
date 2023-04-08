package com.kr.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.bank.dao.MemberDAO;
import com.kr.bank.dto.Member;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	
	@Override
	public void insertMember(Member member) throws Exception {
		
		memberDAO.insertMember(member);
	}

	@Override
	public Member selectMember(String id) {
		return memberDAO.selectMember(id);
	}

}
