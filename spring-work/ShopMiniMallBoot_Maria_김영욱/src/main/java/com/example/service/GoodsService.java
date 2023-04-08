package com.example.service;

import java.util.List;
import com.example.dto.GoodsDTO;

public interface GoodsService {

	public GoodsDTO goodsRetrieve(String gCode);
	public List<GoodsDTO> goodsList();
	
}
