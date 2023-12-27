package com.mirae.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirae.biz.board.BoardVOBU;
import com.mirae.biz.board.implement.BoardDAO;
import com.mirae.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("process update board");
		
		// 1. get info
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sequence = request.getParameter("sequence");
		
		// 2. manage DB
		BoardVOBU vo = new BoardVOBU();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSequence(Integer.parseInt(sequence));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. navigate view
		return "getBoardList";
	}

}
