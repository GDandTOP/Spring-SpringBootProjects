package com.kr.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kr.jpa.entity.Account;
import com.kr.jpa.repository.AccountRepository;
import com.kr.jpa.service.AccountService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaProjApplicationTests {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountService accountService;
	
	@Test
	void contextLoads() {
		Account acc = accountRepository.findById("10001").get();
		System.out.println(acc);
	}
	

	void findAllAcc() {
		List<Account> accs = accountRepository.findAll();
		System.out.println(accs);
	}

	@Test
	void testByType() {
		List<Account> accs = accountRepository.findByType("normal");
		System.out.println(accs);
		
	}
	
	@Test
	void testByTypeAndGrade() {
		List<Account> accs = accountRepository.findByTypeAndGrade("special","VIP");
		System.out.println(accs);
		
	}	
	
	@Test
	void testByContains() {
		List<Account> accs = accountRepository.findByNameContains("길");
		System.out.println(accs);
		
	}	
	
	@Test
	void testByLike() {
		List<Account> accs = accountRepository.findByNameLike("%홍%");
		System.out.println(accs);
		
	}	
	
	@Test
	void transfer() {
		try {
			accountService.trasnfer("10003", "10001", 50000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
