package com.kt.exam.service;

import java.util.List;

import com.kt.exam.dto.Notice;

public interface NoticeService {

	List<Notice> getNoticeList() throws Exception;

	void noticeWrite(Notice notice) throws Exception;

	Notice getNotice(Integer no) throws Exception;

	void modifyNotice(Notice notice) throws Exception;

	List<Notice> noticeSearch(String type, String search) throws Exception;


	void removeNotice(Integer no) throws Exception;

}
