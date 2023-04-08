package com.kr.aop.ex3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect // 공통 관심 모듈
public class LoggingSample {
	
	@Around("execution(* sayHello())")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("[LOG] METHOD: "+methodName+" is calling.");
		Object rtnObj = pjp.proceed();
		sw.stop();

		System.out.println("[LOG] METHOD: "+methodName+" was called.");
		System.out.println("[LOG] 처리시간 "+sw.getLastTaskTimeMillis()/1000+"초");
		return rtnObj;
	}
}
