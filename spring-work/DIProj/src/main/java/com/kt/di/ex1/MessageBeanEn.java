package com.kt.di.ex1;

import org.springframework.stereotype.Component;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello, "+name+"!");
	}
}
