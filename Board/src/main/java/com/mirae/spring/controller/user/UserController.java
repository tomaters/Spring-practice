package com.mirae.spring.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.implement.UserDAO;

@Controller
public class UserController {
	
	@RequestMapping(value="/createAccount.do")
	public String createAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("createAccount()");
		userDAO.createUser(userVO);
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/deleteAccount.do", method = RequestMethod.GET)
	public String deleteAccount(UserVO userVO, UserDAO userDAO) {
		return "deleteAccount";
	}

	@RequestMapping(value="/deleteAccount.do", method = RequestMethod.POST)
	public String deleteAccountSubmit(UserVO userVO, UserDAO userDAO) {
		System.out.println("deleteAccount()");
		System.out.println("mapping: " + userVO.getId() + ", " + userVO.getPassword());
		userDAO.deleteAccount(userVO);
		return "deleteAccountSuccess";
	}
	
	@RequestMapping(value="/login.do")
	public String login(UserVO userVO, UserDAO userDAO, HttpSession session) {
		System.out.println("login()");
		
		if((userVO.getId() == null || userVO.getId().equals("")) || (userVO.getPassword() == null || userVO.getPassword().equals(""))) {
			throw new IllegalArgumentException();
		}
		
		UserVO user = userDAO.getUser(userVO);
		if(user != null) {
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
			return "redirect:getBoardList.do";
		} else return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		System.out.println("logout()");
		session.invalidate();
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/viewAccount.do")
	public String viewAccount(UserDAO userDAO, UserVO userVO, Model model, HttpSession session) {
		System.out.println("viewAccount() id: " + userVO.getId());
		UserVO user = userDAO.viewAccount((String)session.getAttribute("id"));
		model.addAttribute("user", user);
		return "viewAccount";
	}
	
}
