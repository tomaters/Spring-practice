package com.mirae.common;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

// for AfterReturning
@Service("log4")
public class LogAdvice4 {

	public void printLog4(JoinPoint joinPoint, Exception exception) {
		String message = exception.getMessage();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("printLog4 called [after-throwing]");		
		
		if(exception instanceof NumberFormatException) {
			System.out.println(methodName + " threw NumberFormatException");
		}
		if(exception instanceof IllegalArgumentException) {
			System.out.println(methodName + " threw IllegalArgumentException");
		}
		if(exception instanceof NullPointerException) {
			System.out.println(methodName + " threw NullPointerException");
		}
		else {
			System.out.println(methodName + " threw " + message);
		}
	}
}
