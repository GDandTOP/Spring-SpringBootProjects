package com.kt.di.ex1;

import org.springframework.stereotype.Component;

public class MessageBeanKr implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, "+name+"씨!");
	}

}
