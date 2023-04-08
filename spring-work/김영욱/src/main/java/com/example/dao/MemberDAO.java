package com.example.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDTO;


@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public MemberDTO login(Map<String, String> map) {
		
		return null;
	}

	public MemberDTO idCheck(String userid) {
		return sqlSession.selectOne("MemberMapper.idCheck", userid);
	}

	public void memberAdd(MemberDTO dto) {
		sqlSession.insert("MemberMapper.memberAdd",dto);
		
	}

	public MemberDTO mypage(String userid) {
		return null;
	}

	public int memberUpdate(MemberDTO dto) {
		return 0;
	}
}
