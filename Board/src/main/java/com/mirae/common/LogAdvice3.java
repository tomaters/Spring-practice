package com.mirae.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
// for AfterReturning

import com.mirae.user.UserVO;

@Service
@Aspect
public class LogAdvice3 {
	// name of method must match that written in applicationContext.xml
	@Pointcut("execution(* com.mirae..*Implement.get*(..))")
	public void getPointcut() {
		// <aop:after-returning method="printLog3" pointcut-ref="getPointcut"/>
		System.out.println("log3 getPointcut called [after-returning]");
	}
	
	@AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
	public void printLog3(JoinPoint joinPoint, Object returnObj) {
		String methodName = joinPoint.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("User")) {
				System.out.println("Hello " + user.getName());
			}
		}
		System.out.println("printLog3 " + methodName + " called [after-returning]");
	}
}
