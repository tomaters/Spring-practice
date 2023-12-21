package com.mirae.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.implement.UserDAO;
import com.mirae.controller.Controller;

public class ViewAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("process view account");
		HttpSession session = request.getSession();

		// 1. get article number
		String id = (String)session.getAttribute("id");

		System.out.println("ViewAccountController id: " + id);
		
		// 2. manage DB
		UserDAO userDAO = new UserDAO();
		UserVO userVO = null;
		userVO = userDAO.viewAccount(id);
		System.out.println("userVO values: " + userVO.getId() + ", " + userVO.getPassword() + ", " + userVO.getName() + ", " + userVO.getRole());
		// 3. get response view
		session.setAttribute("user", userVO);
		return "viewAccount";
	}
}
