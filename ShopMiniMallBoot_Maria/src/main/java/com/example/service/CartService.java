package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.dto.CartDTO;
import com.example.dto.OrderDTO;

public interface CartService {

	public int orderAllDone(List<OrderDTO> x, List<String> nums) ;
	public List<CartDTO> orderAllConfirm(List<String> x) ;
	public int orderDone(OrderDTO dto, String orderNum);
	public CartDTO cartbyNum(String num);
	public int cartAllDel(List<String> list) ;
	public int cartDel(int num) ;
	public int cartUpdate(Map<String, Integer> map);
	public int cartAdd(CartDTO dto) ;
	public List<CartDTO> cartList(String userid);
	
}
