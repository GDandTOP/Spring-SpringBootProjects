package com.kt.board.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kt.board.dto.Board;
import com.kt.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Board> boards = boardService.getBoardList();
			if(boards.size()>0) {
				mav.addObject("boards", boards);
			}
			mav.setViewName("boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "게시판 목록 조회 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "writeform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView boardWrite(@ModelAttribute Board board, 
			@RequestParam(name="file",required=false) MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.boardWrite(board, file);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "게시판 글 등록 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("num") Integer num) {
		ModelAndView mav = new ModelAndView();
		try {
			Board board=boardService.getBoard(num);
			mav.addObject("article", board);
			mav.setViewName("detailform");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "상세 글 조회 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@PostMapping("boardmoify")
	public ModelAndView boardMoify(@RequestParam("num") Integer num,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.modifyBoard(num, subject, content);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "글 수정 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("num") Integer num) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.removeBoard(num);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "글 삭제 실패");
			mav.setViewName("error");			
		}
		return mav;
	}
	
	@GetMapping("/image")
	public void imageView(@RequestParam("filename") String filename, HttpServletResponse response) {
		try {
			System.out.println(filename);
			String path = "D:/hyj/spring-work/Board/upload/";
			FileInputStream fis = new FileInputStream(path+filename);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fis,out);
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("search")
	public ModelAndView searchBoard(@RequestParam("type") String type, 
			@RequestParam("search")	String search) {
		ModelAndView mav = new ModelAndView();
		try {
			List<Board> boards = boardService.boardSearch(type, search);
			mav.addObject("boards", boards);
			mav.setViewName("boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "게시판 검색 오류");
			mav.setViewName("error");
		}
		return mav;
	}
}
