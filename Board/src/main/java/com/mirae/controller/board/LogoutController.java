package com.mirae.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mirae.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Process logout");
		
		// 1. end session
		HttpSession session = request.getSession();
		session.invalidate();

		// 2. return to main
		return "login";
	}

}
