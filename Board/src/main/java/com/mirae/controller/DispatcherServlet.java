package com.mirae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		System.out.println("DISPATCHER UserVO: " + id + " " + password + " " + name + " " + role);
		
		
		// get info
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// call appropriate controller
		Controller controller = handlerMapping.getController(path);
		
		// process specified controller and retrieve viewName
		String viewName = controller.handleRequest(request, response);
		
		// transfer to view
		// if it has ".do", send viewName redirect. if it does not have ".do", append substrings and send
		if(!viewName.contains(".do")) {
			viewName = viewResolver.getView(viewName);
		}
		response.sendRedirect(viewName);
	}

	@Override
	public void init() throws ServletException {
		// construct Controller object
		handlerMapping = new HandlerMapping();
		
		// create viewResolver object and designate path
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	
}