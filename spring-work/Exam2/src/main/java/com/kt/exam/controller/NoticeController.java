package com.kt.exam.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.kt.exam.dto.Notice;
import com.kt.exam.service.NoticeService;



@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/")
	public ModelAndView NoticeList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Notice> notices = noticeService.getNoticeList();
			if(notices.size()>0) {
				mav.addObject("notices", notices);
			}
			mav.setViewName("list");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("list");
		}
		return mav;
	}
	

	@GetMapping("/list")
	public String getList() {
		return "redirect:/";
	}
	
	//	검색기능 구현
	@GetMapping("/search")
	public ModelAndView searchList(@RequestParam("searchName") String searchName, 
	@RequestParam("searchValue") String searchValue) {
		ModelAndView mav = new ModelAndView();
		try {
			List<Notice> notices = noticeService.noticeSearch(searchName, searchValue);
			mav.addObject("notices", notices);
			mav.setViewName("list");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("list");
		}
		return mav;
	}
	
	@GetMapping("/write")
	public String wrietForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public ModelAndView noticeWrite(@ModelAttribute Notice notice) {
		ModelAndView mav = new ModelAndView();
		try {
			noticeService.noticeWrite(notice);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	
	@GetMapping("/image/ktds")
	public void imageView(HttpServletResponse response) {
		try {
			String path = "C:/Users/ktds/Desktop/YoungukJava/java_workspace/spring-work/Exam2/upload/ktds.png"; //이미지 위치
			FileInputStream fis = new FileInputStream(path);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fis,out);
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("no") Integer no) {
		ModelAndView mav = new ModelAndView();
		try {
			Notice notice = noticeService.getNotice(no);
			mav.addObject("notice", notice);
			mav.setViewName("retrieve");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	@PostMapping("update")
	public ModelAndView NoticeModify(@ModelAttribute Notice notice) {
		ModelAndView mav = new ModelAndView();
		try {
			noticeService.modifyNotice(notice);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("no") Integer no) {
		ModelAndView mav = new ModelAndView();
		try {
			noticeService.removeNotice(no);
			mav.setViewName("redirect:/");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
}
