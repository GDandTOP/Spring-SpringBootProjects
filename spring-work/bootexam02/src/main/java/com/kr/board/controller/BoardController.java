package com.kr.board.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.kr.board.entity.Board;
import com.kr.board.entity.Member;
import com.kr.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/home")
	public String main() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		try {
			List<Board> boards = boardService.boardList();
			mav.addObject("boards",boards);
			mav.setViewName("list");
		} catch (Exception e)
		{
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/write")
	public String write() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public ModelAndView boardWrite(@ModelAttribute Board board) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.boardWrite(board);
			List<Board> boards = boardService.boardList();
			mav.addObject("boards",boards);
			mav.setViewName("redirect:/list");
			
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView boardModify(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("no") Integer no) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.boardModify(title, content, no);
			List<Board> boards = boardService.boardList();
			mav.addObject("boards",boards);
			mav.setViewName("redirect:/list");
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	

	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	
	

	@GetMapping("/detail/{no}")
	public ModelAndView boardDetail(@PathVariable Integer no) {
		ModelAndView mv = new ModelAndView();
		try {
			Board board = boardService.boardDetail(no);
			mv.addObject("board", board);
			mv.setViewName("retrieve");
		} catch(Exception e) {
			e.printStackTrace();
			mv.setViewName("error");
		}
		return mv;
	}

	
	@GetMapping("/delete/{no}")
	public ModelAndView deleteBoard(@PathVariable Integer no) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.deleteBoard(no);
			List<Board> boards = boardService.boardList();
			mav.addObject("boards",boards);
			mav.setViewName("redirect:/list");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}

	@PostMapping("/search")
	public ModelAndView search(@RequestParam("searchName") String type, @RequestParam("searchValue") String word) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Board> boards = boardService.searchBoard(type, word);

			mv.addObject("boards", boards);
			mv.setViewName("list");
		} catch(Exception e) {
			e.printStackTrace();
			mv.addObject("err","검색 오류");
			mv.setViewName("error");
		}
		return mv;
	}
	

}
