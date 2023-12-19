//package com.mirae.spring.controller.board;
//
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.servlet.ModelAndView;
//
//import com.mirae.biz.board.BoardVO;
//import com.mirae.biz.board.implement.BoardDAO;
//
//@Controller
//public class InsertBoardController {

	// transferred to BoardController
//	@RequestMapping(value="/insertBoard.do")
//	public String insertBoard(BoardDAO boardDAO, BoardVO boardVO) {
//		System.out.println("insertBoard()");
//		boardDAO.insertBoard(boardVO);
//		return "redirect:getBoardList.do";
//	}
	
//	public ModelAndView insertBoard(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("process insert board");
//
//		// 1. get info
//			String title = request.getParameter("title");
//			String username = request.getParameter("username");
//			String content = request.getParameter("content");
//			
//		// 2. manage DB
//			BoardVO vo = new BoardVO();
//			vo.setTitle(title);
//			vo.setUsername(username);
//			vo.setContent(content);
//			
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.insertBoard(vo);
//			
//		// 3. navigate view
//			ModelAndView mav = new ModelAndView();
//			// view resolver
//			mav.setViewName("redirect:getBoardList.do");
//			return mav;
//	}
//}
