package com.kr.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Repository
@Entity
public class Member {
	@Id
	private String id;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String sex;
	@Column
	private Integer age;
	@Column
	private String email;
}
