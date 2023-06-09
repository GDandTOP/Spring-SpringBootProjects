package com.example.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDTO;


@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate session;

	public MemberDTO login(Map<String, String> map) {
		MemberDTO n = session.selectOne("MemberMapper.login", map);
		return n;
	}

	public int idCheck(String userid) {
		int count = session.selectOne("MemberMapper.idCheck", userid);
		return count;
	}

	public int memberAdd(MemberDTO dto) {
		int n = session.insert("MemberMapper.memberAdd", dto);
		return n;
	}

	public MemberDTO mypage(String userid) {
		MemberDTO n = session.selectOne("MemberMapper.mypage", userid);
		return n;
	}

	public int memberUpdate(MemberDTO dto) {
		int n = session.insert("MemberMapper.updateMember", dto);
		return n;
	}
}
