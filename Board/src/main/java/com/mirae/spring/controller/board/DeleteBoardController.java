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
//public class DeleteBoardController {


	// pasted into BoardController
//	@RequestMapping(value="/deleteBoard.do")
//	public String deleteBoard(BoardVO boardVO, BoardDAO boardDAO) {
//		System.out.println("deleteBoard()");
//		boardDAO.deleteBoard(boardVO);
//		return "getBoardList";
		
	
	// STS container does everything else
//	public ModelAndView deleteBoard(HttpServletRequest request, HttpServletResponse response) {
//		// 1. get info
//		String sequence = request.getParameter("sequence");
//
//		// 2. manage DB
//		BoardVO vo = new BoardVO();
//		vo.setSequence(Integer.parseInt(sequence));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		// 3. navigate view
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("deleteBoard");
//		return mav;
//	}
//}
