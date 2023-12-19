//package com.mirae.spring.controller.user;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.mirae.biz.user.UserVO;
//import com.mirae.biz.user.bimplement.UserDAO;
//
//@Controller
//public class CreateAccountController {
//	
	// transferred to UserController
//	@RequestMapping(value="/createAccount.do")
//	public String createAccount(UserVO userVO, UserDAO userDAO) {
//		System.out.println("createAccount()");
//		userDAO.createUser(userVO);
//		return "redirect:login.jsp";
//	}
	
//	STS container does everything else
//	public ModelAndView createAccount(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("process create account");
//
//		// 1. get article number
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String role = request.getParameter("role");
//
//		System.out.println(id + " " + password + " " + name + " " + role);
//		
//		// 2. manage DB
//		UserVO userVO = new UserVO();
//		userVO.setId(id);
//		userVO.setPassword(password);
//		userVO.setName(name);
//		userVO.setRole(role);
//		
//		UserDAO userDAO = new UserDAO();
//		userDAO.createUser(userVO);
//
//		// 3. get response view
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}
//}
