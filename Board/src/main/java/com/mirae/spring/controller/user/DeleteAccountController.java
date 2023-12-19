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
//public class DeleteAccountController {
//
//	@RequestMapping(value="/deleteAccount.do")
//	public String deleteAccount(UserVO userVO, UserDAO userDAO) {
//		System.out.println("deleteAccount()");
//		userDAO.deleteAccount(userVO);
//		return "redirect:login.jsp";
//	}
	
//	public ModelAndView deleteAccount(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("process delete account");
//		
//		// 1. get info
//		String id = request.getParameter("id");
//
//		// 2. manage DB
//		UserVO userVO = new UserVO();
//		userVO.setId(id);
//		
//		UserDAO userDAO = new UserDAO();
//		userDAO.deleteAccount(userVO);
//		
//		// 3. navigate view
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}
//}
