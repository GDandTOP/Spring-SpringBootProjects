package com.kt.exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kt.exam.dao.NoticeDAO;
import com.kt.exam.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDAO noticeDAO;
	
	@Override
	public List<Notice> getNoticeList() throws Exception {
		return noticeDAO.selectNoticeList();
	}
	
	@Override
	public void noticeWrite(Notice notice) throws Exception {
		noticeDAO.insertNotice(notice);
	}
	
	@Override
	public Notice getNotice(Integer no) throws Exception {
		noticeDAO.updateReadCnt(no);
		return noticeDAO.selectNotice(no);
	}
	
	@Override
	public void modifyNotice(Notice notice) throws Exception {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("no",notice.getNo() );
		params.put("title", notice.getTitle());
		params.put("author", notice.getAuthor());
		params.put("content", notice.getContent());
		noticeDAO.updateNotice(params);
	}
	
	@Override
	public List<Notice> noticeSearch(String type, String search) throws Exception {
		List<Notice> notices = null;
		
		if(type.equals("author")) {

			notices = noticeDAO.selectByAuthor(search);
		} else if(type.equals("title")) {

			notices = noticeDAO.selectByTitle(search);
			
		} 
		
		if(search==null || search.equals("")) {

			notices = noticeDAO.selectNoticeList();
		}
		return notices;
	}

	@Override
	public void removeNotice(Integer no) throws Exception {
		noticeDAO.removeNotice(no);
		
	}

	
}
