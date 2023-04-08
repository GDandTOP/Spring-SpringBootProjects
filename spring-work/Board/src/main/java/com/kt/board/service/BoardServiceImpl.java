package com.kt.board.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kt.board.dao.BoardDAO;
import com.kt.board.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<Board> getBoardList() throws Exception {
		return boardDAO.selectBoardList();
	}

	@Override
	public void boardWrite(Board board, MultipartFile mfile) throws Exception {
		if(mfile!=null && !mfile.isEmpty()) {
			String path = "D:/hyj/spring-work/Board/upload/";
			File destfile = new File(path+mfile.getOriginalFilename());
			mfile.transferTo(destfile);
			board.setFilename(mfile.getOriginalFilename());
		}
		boardDAO.insertBoard(board);
	}

	@Override
	public Board getBoard(Integer num) throws Exception {
		boardDAO.updateReadCnt(num);
		return boardDAO.selectBoard(num);
	}

	@Override
	public void modifyBoard(Integer num, String subject, String content) throws Exception {
		HashMap<String, Object> params = new HashMap<>();
		params.put("num", num);
		params.put("subject", subject);
		params.put("content", content);
		boardDAO.updateBoard(params);
	}

	@Override
	public void removeBoard(Integer num) throws Exception {
		boardDAO.deleteBoard(num);
	}

	@Override
	public List<Board> boardSearch(String type, String search) throws Exception {
		List<Board> boards = null;
		if(type.equals("writer")) {
			boards = boardDAO.selectByWriter(search);
		} else if(type.equals("subject")) {
			boards = boardDAO.selectBySubject(search);
		} else if(type.equals("content")) {
			boards = boardDAO.selectByContent(search);
		} else {
			boards = boardDAO.selectBoardList();
		}
		return boards;
	}
}