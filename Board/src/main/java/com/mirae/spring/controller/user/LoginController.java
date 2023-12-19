package com.mirae.spring.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
// IMPORT SPRING CONTROLLER
import org.springframework.web.servlet.mvc.Controller;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.bimplement.UserDAO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			// if *.do is sent, it will call /getBoardList.do and not directly call a view
			mav.setViewName("getBoardList.do");
//			return "getBoardList.do";
		} else {
			// not login.jsp because it will be appended later (WEB-INF/ will also be added to the front
			mav.setViewName("login.jsp");
//			return "login";
		}
		return mav;
	}

}
