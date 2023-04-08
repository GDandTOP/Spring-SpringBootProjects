package com.kr.board.service;


import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kr.board.entity.Board;
import com.kr.board.entity.Member;
import com.kr.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	@Autowired
	ServletContext servletContxt;
	
	@Autowired
	private HttpSession session; 
	
	public List<Board> boardList() throws Exception {
		return boardRepository.findAll(Sort.by(Sort.Direction.ASC,"no"));
	}
	
	public void boardWrite(Board board) throws Exception {
		Member member = (Member)session.getAttribute("member");
		String userid = member.getUserid();
		board.setUserid(userid);
		boardRepository.save(board);
	}
//	
	public Board boardDetail(Integer no) throws Exception {
		Optional<Board> oboard = boardRepository.findById(no);
		if(oboard.isEmpty()) throw new Exception("글번호 오류");
		Board board = oboard.get();
		boardRepository.readCntInc(no);
		return board;
	}
	
	public void deleteBoard(Integer no) throws Exception {
		boardRepository.deleteById(no);
	}

	public List<Board> searchBoard(String type, String word) throws Exception {
		if(word.equals("")) {
			return boardList();
		} else if(type.equals("username")) {
			return boardRepository.findByUsernameContainsOrderByNoAsc(word);
		} else if(type.equals("title")) {
			return boardRepository.findByTitleContainsOrderByNoAsc(word);
		}  else return boardList();
	}
	
	public void boardModify(String title, String content, Integer no) throws Exception {
		boardRepository.updateBoard(title, content, no);
	}
}
