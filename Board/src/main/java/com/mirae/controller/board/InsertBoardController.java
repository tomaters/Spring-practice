package com.mirae.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirae.board.BoardVO;
import com.mirae.board.implement.BoardDAO;
import com.mirae.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
			return "getBoardList.do";
	}
}
