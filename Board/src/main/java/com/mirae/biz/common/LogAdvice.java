package com.mirae.biz.common;

import org.aspectj.lang.JoinPoint;

// for After
public class LogAdvice {

	public void printLog(JoinPoint joinPoint) {
		System.out.println("printLog called [after]");
		String methodName = joinPoint.getSignature().getName();
		String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("methodName: " + methodName + ", declaringTypeName: " + declaringTypeName);
		System.out.println("args: " + args[0].toString());
	}
}
