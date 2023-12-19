package com.mirae.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.board.implement.BoardDAO;
import com.mirae.biz.user.UserVO;
import com.mirae.biz.user.bimplement.UserDAO;

public class DispatcherServletBU extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		if (path.equals("/login.do")) {
			System.out.println("Process login");
			// 1. get user info
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. manage DB
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. navigate view
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("Process logout");
			
			// 1. end session
			HttpSession session = request.getSession();
			session.invalidate();

			// 2. return to main
			response.sendRedirect("login.jsp");
			

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("process insert board");

			// 1. get info
				String title = request.getParameter("title");
				String username = request.getParameter("username");
				String content = request.getParameter("content");
				
			// 2. manage DB
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setUsername(username);
				vo.setContent(content);
				
				BoardDAO boardDAO = new BoardDAO();
				boardDAO.insertBoard(vo);
				
			// 3. navigate view
				response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("process update board");
			
			// 1. get info
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String sequence = request.getParameter("sequence");
			
			// 2. manage DB
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSequence(Integer.parseInt(sequence));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. navigate view
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("process delete board");
			
			// 1. get info
			String sequence = request.getParameter("sequence");

			// 2. manage DB
			BoardVO vo = new BoardVO();
			vo.setSequence(Integer.parseInt(sequence));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. navigate view
			response.sendRedirect("deleteBoard.jsp");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("Search function");

			// 1. get article number
			String sequence = request.getParameter("sequence");

			// 2. manage DB
			BoardVO vo = new BoardVO();
			vo.setSequence(Integer.parseInt(sequence));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);

			// 3. get response view
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");

		} else if (path.equals("/getBoardList.do")) {
			System.out.println("Process get board list");

			// 1. get info
			// 2. manage DB
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 3. get response view
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}
}