//package com.mirae.spring.controller.user;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.mirae.biz.user.UserVO;
//import com.mirae.biz.user.bimplement.UserDAO;
//
//@Controller
//public class ViewAccountController {

	// transferred to UserController
//	@RequestMapping(value="viewAccount.do")
//	public String viewAccount(UserDAO userDAO, UserVO userVO, Model model) {
//		System.out.println("viewAccount()");
//		userVO = userDAO.viewAccount(userVO.getId());
//		model.addAttribute("user", userVO);
//		return "viewAccount";
	
	// STS does everything else
//	public ModelAndView viewAccount(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("process view account");
//		HttpSession session = request.getSession();
//
//		// 1. get article number
//		String id = (String)session.getAttribute("id");
//
//		System.out.println("ViewAccountController id: " + id);
//		
//		// 2. manage DB
//		UserDAO userDAO = new UserDAO();
//		UserVO userVO = null;
//		userVO = userDAO.viewAccount(id);
//		System.out.println("userVO values: " + userVO.getId() + ", " + userVO.getPassword() + ", " + userVO.getName() + ", " + userVO.getRole());
//		// 3. get response view
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("user", userVO);
//		mav.setViewName("viewAccount");
//		return mav;
//	}
//}
