package com.kr.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kr.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Board b set b.readcnt=b.readcnt+1 where b.no=:no")
	public void readCntInc(@Param("no") Integer no);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Board b set b.title=:title, b.content=:content where b.no=:no")
	public void updateBoard(@Param("title") String title, 
			@Param("content") String content, @Param("no") Integer no);	
	
	public List<Board> findByUsernameContainsOrderByNoAsc(String word);
	public List<Board> findByTitleContainsOrderByNoAsc(String word);
//	public List<Board> findByContentContainsOrderByNumDesc(String word);
}
