//package com.mirae.spring.controller.user;
//
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.servlet.ModelAndView;

//@Controller
//public class LogoutController {
//		
//	@RequestMapping(value="/logout.do")
//	public String logout(HttpSession session) {
//		System.out.println("logout()");
//		session.invalidate();
//		return "redirect:login.jsp";
//	}
	
	// STS container does everything else
//	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Process logout");
//		
//		// 1. end session
//		HttpSession session = request.getSession();
//		session.invalidate();
//
//		// 2. return to main
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}
//}
