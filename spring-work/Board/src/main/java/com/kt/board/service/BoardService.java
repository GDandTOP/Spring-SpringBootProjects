package com.kt.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kt.board.dto.Board;

public interface BoardService {
	List<Board> getBoardList() throws Exception;
	void boardWrite(Board board, MultipartFile file) throws Exception;
	Board getBoard(Integer num) throws Exception;
	void modifyBoard(Integer num, String subject, String content) throws Exception;
	void removeBoard(Integer num) throws Exception;
	List<Board> boardSearch(String type, String search) throws Exception;
}
