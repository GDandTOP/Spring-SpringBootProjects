package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CartDAO;
import com.example.dto.CartDTO;
import com.example.dto.OrderDTO;


@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDAO dao;

	public int orderAllDone(List<OrderDTO> x, List<String> nums) {
		for (int i=0; i<x.size(); i++) {
			dao.orderDone(x.get(i));
			dao.cartDel(Integer.parseInt(nums.get(i)));
		}
		return 1;
	}

	public List<CartDTO> orderAllConfirm(List<String> x) {
		List<CartDTO> list = null;
		list = dao.orderAllConfirm(x);
		return list;
	}

	@Transactional
	public int orderDone(OrderDTO dto, String orderNum) {
		dao.orderDone(dto);
		return dao.cartDel(Integer.parseInt(orderNum));
		
	}

	public CartDTO cartbyNum(String num) {
		CartDTO dto = dao.cartbyNum(num);
		return dto;
	}

	public int cartAllDel(List<String> list) {
		for (String i : list) {
			int num = Integer.parseInt(i);
			dao.cartDel(num);
		}
		return 1;
	}

	public int cartDel(int num) {
		int n = dao.cartDel(num);
		return n;
	}

	public int cartUpdate(Map<String, Integer> map) {
		int n = dao.cartUpdate(map);
		return n;
	}

	public int cartAdd(CartDTO dto) {
		int n = dao.cartAdd(dto);
		return n;
	}

	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = dao.cartList(userid);
		return list;
	}
}
