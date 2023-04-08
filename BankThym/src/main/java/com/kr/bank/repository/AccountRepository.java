package com.kr.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kr.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	public List<Account> findByType(String type);
	public List<Account> findByTypeAndGrade(String type, String grade);
	
	public List<Account> findByNameContains(String name);
	public List<Account> findByNameLike(String name);
	
	@Modifying(clearAutomatically = true)
	@Query("update Account a set a.balance=a.balance-:money where a.id=:id")
	public int updateWithdraw(@Param("id") String id,
		@Param("money") Integer money);
	
	@Modifying(clearAutomatically = true)
	@Query("update Account a set a.balance=a.balance+:money where a.id=:id")
	public int updateDeposit(@Param("id") String id,
		@Param("money") Integer money);
}
