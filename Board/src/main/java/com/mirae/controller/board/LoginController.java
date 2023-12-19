package com.mirae.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirae.controller.Controller;
import com.mirae.user.UserVO;
import com.mirae.user.implement.UserDAO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Process login");
		// 1. get user info
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. manage DB
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. navigate view
		if (user != null) {
			// if *.do is sent, it will call /getBoardList.do and not directly call a view
			return "getBoardList.do";
		} else {
			// not login.jsp because it will be appended later (WEB-INF/ will also be added to the front
			return "login";
		}
	}

}
