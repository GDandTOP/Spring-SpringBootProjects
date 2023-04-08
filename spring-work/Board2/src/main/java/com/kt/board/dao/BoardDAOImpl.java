package com.kt.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kt.board.dto.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Board> selectBoardList() throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList");
	}

	@Override
	public void insertBoard(Board board) throws Exception {	
			sqlSession.insert("mapper.board.insertBoard",board);
		
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard",num);
	}

	@Override
	public void updateBoard(HashMap<String, Object> params) throws Exception {
		sqlSession.update("mapper.board.updateBoard", params);
	}

	@Override
	public void deleteBoard(Integer num) throws Exception {
		sqlSession.delete("mapper.board.deleteBoard", num);
	}

	@Override
	public void updateReadCnt(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateReadCnt", num);
	}

	@Override
	public List<Board> selectByWriter(String writer) throws Exception {
		return sqlSession.selectList("mapper.board.selectByWriter", writer);
	}

	@Override
	public List<Board> selectBySubject(String subject) throws Exception {
		return sqlSession.selectList("mapper.board.selectBySubject", subject);
	}

	@Override
	public List<Board> selectByContent(String content) throws Exception {
		return sqlSession.selectList("mapper.board.selectByContent", content);
	}
	
	
}
