package com.example.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.CartDTO;
import com.example.dto.OrderDTO;


@Repository
public class CartDAO {
	@Autowired
	SqlSessionTemplate session;
	public int orderAllDone(List<OrderDTO> x) {
		/*
		 * 
		 */
		return 0;
	}
	
	public List<CartDTO> orderAllConfirm(List<String> list) {
		/*
		 * 
		 */
		return null;
	}
	
	public int orderDone(OrderDTO dto) {
		return session.insert("CartMapper.orderDone",dto);
	}
	
	public CartDTO cartbyNum(String num) {
		return session.selectOne("CartMapper.cartbyNum",num);
	}
	
	public int cartAllDel(List<String> list) {
		return 0;
//		return session.delete("CartMapper.cartAllDel");
	}
	
	public int cartDel( int num) {
		return session.delete("CartMapper.cartDel",num);
	}
	
	public int cartUpdate( Map<String, Integer> map) {
		return session.update("CartMapper.cartUpdate",map);
	}
	public int cartAdd(CartDTO dto) {
		return session.insert("CartMapper.cartAdd",dto);
	}

	public List<CartDTO> cartList(String userid) {
		return session.selectList("CartMapper.cartList",userid);
	}
}
