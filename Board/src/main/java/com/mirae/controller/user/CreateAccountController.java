package com.mirae.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.implement.UserDAO;
import com.mirae.controller.Controller;

public class CreateAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("process create account");

		// 1. get article number
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		System.out.println(id + " " + password + " " + name + " " + role);
		
		// 2. manage DB
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPassword(password);
		userVO.setName(name);
		userVO.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.createUser(userVO);

		// 3. get response view
		return "login.do";
	}
}
