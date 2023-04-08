package com.kt.exam.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kt.exam.dto.Notice;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Notice> selectNoticeList() throws Exception {
		return sqlSession.selectList("mapper.notice.selectNoticeList");
	}

	@Override
	public void insertNotice(Notice notice) throws Exception {
		sqlSession.insert("mapper.notice.insertNotice",notice);
	}

	@Override
	public Notice selectNotice(Integer no) {
		return sqlSession.selectOne("mapper.notice.selectNotice",no);
	}

	@Override
	public void updateNotice(HashMap<String, Object> params) {
			sqlSession.update("mapper.notice.updateNotice",params);
		
	}
	
	@Override
	public void updateReadCnt(Integer no) throws Exception {
		sqlSession.update("mapper.notice.updateReadCnt", no);
	}

	@Override
	public List<Notice> selectByAuthor(String author) throws Exception {
		return sqlSession.selectList("mapper.notice.selectByAuthor", author);
	}

	@Override
	public List<Notice> selectByTitle(String title) throws Exception {
		return sqlSession.selectList("mapper.notice.selectByTitle", title);
	}

	@Override
	public void removeNotice(Integer no) throws Exception {
		sqlSession.delete("mapper.notice.deleteNotice", no);
		
	}




}
