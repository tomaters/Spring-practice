//package com.mirae.spring.controller.user;
//
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.servlet.ModelAndView;
//
//import com.mirae.biz.user.UserVO;
//import com.mirae.biz.user.bimplement.UserDAO;
//
//@Controller
//public class LoginController {
//	
	// transferred to UserController
//	@RequestMapping(value="/login.do")
//	public String login(UserVO userVO, UserDAO userDAO) {
//		System.out.println("login()");
//		UserVO user = userDAO.getUser(userVO);
//		if(user != null) {
//			return "redirect:getBoardList.do";
//		} else return "redirect:login.jsp";
//	}
	
	// STS container does everything else
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Process login");
//		// 1. get user info
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		// 2. manage DB
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//
//		// 3. navigate view
//		ModelAndView mav = new ModelAndView();
//		if (user != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("id", id);
//			// if *.do is sent, it will call /getBoardList.do and not directly call a view
//			// redirect added because of view resolver
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			// not login.jsp because it will be appended later (WEB-INF/ will also be added to the front
//			// redirect added because of view resolver
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
//	}
//}
