package com.mirae.spring.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.bimplement.UserDAO;

public class CreateAccountController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
	}
}
