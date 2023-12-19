package com.mirae.spring.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.board.implement.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("process delete board");
		
		// 1. get info
		String sequence = request.getParameter("sequence");

		// 2. manage DB
		BoardVO vo = new BoardVO();
		vo.setSequence(Integer.parseInt(sequence));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. navigate view
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteBoard.jsp");
		return mav;
	}

}
