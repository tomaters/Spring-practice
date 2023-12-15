package com.mirae.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO userVO = new UserVO();
		userVO.setId("Admin");
		userVO.setPassword("Admin");
		
		UserVO user = userService.getUser(userVO);
		if(user != null) {
//			System.out.println("Welcome, " + user.getName());
		} else System.out.println("Login failed");
		container.close();
	}
}
