package com.kr.bank.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.kr.bank.dto.Member;



@Repository
@Mapper
public interface MemberDAO {
	void insertMember(Member member) throws Exception;
	Member selectMember(String id);
}
