package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.GoodsDTO;


@Repository
public class GoodsDAO {
	@Autowired
	SqlSessionTemplate session;
	public GoodsDTO goodsRetrieve(String gCode) {
		return session.selectOne("GoodsMapper.goodsRetrieve",gCode);
	}

	public List<GoodsDTO> goodsList() {
		return session.selectList("GoodsMapper.goodsList");
		
	}
}
