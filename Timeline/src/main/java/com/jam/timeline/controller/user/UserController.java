package com.jam.timeline.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jam.timeline.biz.event.EventVO;
import com.jam.timeline.biz.event.ScheduleVO;
import com.jam.timeline.biz.user.UserVO;
import com.jam.timeline.biz.user.impl.UserDAO;
@SessionAttributes("user")
@Controller
public class UserController {

	@RequestMapping(value = "/createAccount.do")
	public String createAccount(UserVO userVO, UserDAO userDAO) {
		System.out.println("createAccount()");
		System.out.println(userVO.toString());
		userDAO.createAccount(userVO);
		return "redirect:login.jsp";
	}

	@RequestMapping(value = "/login.do")
	public String login(UserVO userVO, UserDAO userDAO, HttpSession session, Model model) {
		System.out.println("login(): " + userVO.toString());
		if (userVO.getUsername() == null || userVO.getPassword() == null) {
			System.out.println("null error");
		}
		UserVO user = userDAO.login(userVO);
		if (user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("name", user.getName());
			session.setAttribute("reg_date", user.getReg_date().toString());
			session.setAttribute("profpic_path", user.getProfpic_path());
			System.out.println("after login(): " + user.toString());
			return "timeline";
		} else
			return "redirect:login.jsp";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		System.out.println("logout()");
		session.invalidate();
		return "redirect:home.jsp";
	}
	
	@RequestMapping(value = "/myAccount.do")
	public String myAccount(UserVO userVO, EventVO eventVO, ScheduleVO scheduleVO) {
		return "myAccount";
	}
}
