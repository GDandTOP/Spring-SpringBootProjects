package com.kr.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kr.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
