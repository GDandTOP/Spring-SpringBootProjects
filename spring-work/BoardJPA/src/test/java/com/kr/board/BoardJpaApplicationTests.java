package com.kr.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kr.board.repository.BoardRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardJpaApplicationTests {
	
	@Autowired
	BoardRepository boardRepository;
	@Test
	void contextLoads() {
		
//		boardRepository.readCntInc(3);
	}

}
