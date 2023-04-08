package com.kt.board.dao;

import java.util.HashMap;
import java.util.List;

import com.kt.board.dto.Board;

public interface BoardDAO {
	List<Board> selectBoardList() throws Exception;
	void insertBoard(Board board) throws Exception;
	Board selectBoard(Integer num) throws Exception;
	void updateBoard(HashMap<String,Object> params) throws Exception;
	void deleteBoard(Integer num) throws Exception;
	void updateReadCnt(Integer num) throws Exception;
	List<Board> selectByWriter(String writer) throws Exception;
	List<Board> selectBySubject(String subject) throws Exception;
	List<Board> selectByContent(String content) throws Exception;
}
