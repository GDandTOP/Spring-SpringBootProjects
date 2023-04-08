package com.kr.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Repository
@Entity
@Getter
@Setter
public class Member {
	@Id
	private String userid;
	@Column
	private String passwd;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String phone;
}
