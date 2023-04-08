package com.kt.exam.dao;

import java.util.HashMap;
import java.util.List;

import com.kt.exam.dto.Notice;

public interface NoticeDAO {
	List<Notice> selectNoticeList() throws Exception;
	void insertNotice(Notice notice) throws Exception;
	Notice selectNotice(Integer no) throws Exception;
	void updateNotice(HashMap<String, Object> params) throws Exception;
	void updateReadCnt(Integer no) throws Exception;
	List<Notice> selectByAuthor(String search) throws Exception;
	List<Notice> selectByTitle(String search) throws Exception;
	void removeNotice(Integer no) throws Exception;
	
	
}
