package com.mirae.biz.common;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

import com.mirae.biz.user.UserVO;

// for Before
public class LogAdvice2 {

	public void printLog2(JoinPoint joinPoint, Object returnObj) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		Object obj = joinPoint.getTarget();
		Date date = new Date();
		// take return value and check
		if(returnObj instanceof UserVO) {
			// downcasting
			UserVO userVO = (UserVO) returnObj;
			if(userVO.getRole().equals("Admin")) {
				System.out.println("Hello, " + userVO.getName() + "! " + date.toString());
			} else {
				System.out.println("Hello, " + userVO.getName() + ". "+ date.toString());
			}
		}
		System.out.println("printLog2() called [after-returning (changed from before)] " + methodName + " return value: " + 
		args[0].toString() + ", class: " + obj.toString());
	}
}
