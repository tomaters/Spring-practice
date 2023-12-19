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
//public class UpdateBoardController {

	// transferred to BoardController
//	@RequestMapping(value="/updateBoard.do")
//	public String updateBoard(BoardDAO boardDAO, BoardVO boardVO) {
//		System.out.println("updateBoard()");
//		boardDAO.updateBoard(boardVO);
//		return "redirect:getBoardList.do";
//	}
	
//	public ModelAndView updateBoard(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("process update board");
//		
//		// 1. get info
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String sequence = request.getParameter("sequence");
//		
//		// 2. manage DB
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSequence(Integer.parseInt(sequence));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
//		
//		// 3. navigate view
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

//}
