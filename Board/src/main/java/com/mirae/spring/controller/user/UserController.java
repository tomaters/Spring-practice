package com.mirae.spring.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.bimplement.UserDAO;

@Controller
public class UserController {

	@RequestMapping(value="/createAccount.do")
	public String createAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("createAccount()");
		userDAO.createUser(userVO);
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/deleteAccount.do")
	public String deleteAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("deleteAccount()");
		userDAO.deleteAccount(userVO);
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/login.do")
	public String login(UserVO userVO, UserDAO userDAO) {
		System.out.println("login()");
		UserVO user = userDAO.getUser(userVO);
		if(user != null) {
			return "redirect:getBoardList.do";
		} else return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		System.out.println("logout()");
		session.invalidate();
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="viewAccount.do")
	public String viewAccount(UserDAO userDAO, UserVO userVO, Model model) {
		System.out.println("viewAccount()");
		UserVO user = userDAO.viewAccount(userVO.getId());
		model.addAttribute("user", user);
		return "viewAccount";
	}
}
