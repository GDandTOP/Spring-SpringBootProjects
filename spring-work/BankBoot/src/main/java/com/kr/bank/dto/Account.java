package com.kr.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private String id;
	private String name;
	private Integer balance;
	private String type;
	private String grade;
	
	
	
	public void deposit(int money) {
		if(money>0) {
			balance += money;
		}
	}
	
	public void withdraw(int money) {
		if(balance>=money) {
			balance -= money;
		}
	}
}
