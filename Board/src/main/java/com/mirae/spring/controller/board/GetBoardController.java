package com.mirae.spring.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.board.implement.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Search function");

		// 1. get article number
		String sequence = request.getParameter("sequence");

		// 2. manage DB
		BoardVO vo = new BoardVO();
		vo.setSequence(Integer.parseInt(sequence));

		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);

		ModelAndView mav = new ModelAndView();
		// 3. get response view
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
