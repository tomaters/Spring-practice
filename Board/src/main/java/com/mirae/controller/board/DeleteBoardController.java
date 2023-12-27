package com.mirae.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirae.biz.board.BoardVOBU;
import com.mirae.biz.board.implement.BoardDAO;
import com.mirae.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("process delete board");
		
		// 1. get info
		String sequence = request.getParameter("sequence");

		// 2. manage DB
		BoardVOBU vo = new BoardVOBU();
		vo.setSequence(Integer.parseInt(sequence));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. navigate view
		return "deleteBoard";
	}

}
