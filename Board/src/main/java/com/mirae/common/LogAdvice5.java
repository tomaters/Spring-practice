package com.mirae.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// for AroundAdvice
@Service("log5")
public class LogAdvice5 {

	public Object printLog5(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("printLog5 logic before business method [around]");
		// StopWatch times how long processing takes
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = proceedingJoinPoint.proceed();
		stopWatch.stop();
		System.out.println("printLog5 logic after business method [around]");
		System.out.println("stopWatch time: " + stopWatch.getTotalTimeMillis() + "ms");
		System.out.println("method name: " + proceedingJoinPoint.getSignature().getName());
		return obj;
	}
}
