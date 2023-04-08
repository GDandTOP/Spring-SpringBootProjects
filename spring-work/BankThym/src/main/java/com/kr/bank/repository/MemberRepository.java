package com.kr.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kr.bank.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
