package com.mirae.spring.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.board.implement.BoardDAO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getBoardList.do");
			return mav;
	}
}
