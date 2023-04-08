package com.kt.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kt.bank.dto.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	} 위의 두개의 어노테이션이 있으면 생략 가능
	
	
	
	@Override
	public void joinMember(Member member) throws Exception {
		System.out.println("멤버 정보 :"+" "+member.getEmail()+" "+member.getId()+" "+member.getName()+" "+member.getGender()+" "+member.getAge());
		
		sqlSession.insert("mapper.member.joinMember",member);
		
	}

	@Override
	public Member loginMember(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.loginMember",id);
	}

	


}
