package com.mirae.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mirae.biz.board.BoardVOBU;
import com.mirae.biz.board.implement.BoardDAO;
import com.mirae.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Process get board list");

		// 1. get info
		// 2. manage DB
		BoardVOBU vo = new BoardVOBU();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVOBU> boardList = boardDAO.getBoardList(vo);

		// 3. get response view
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}
}
