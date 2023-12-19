//package com.mirae.spring.controller.board;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.mirae.biz.board.BoardVO;
//import com.mirae.biz.board.implement.BoardDAO;
//
//@Controller
//public class GetBoardController {
//
//	// transferred to BoardController
//	@RequestMapping(value="/getBoard.do")
//	public String getBoard(BoardVO boardVO, BoardDAO boardDAO, Model model) {
//		System.out.println("getBoard()");
//		BoardVO board = boardDAO.getBoard(boardVO);
//		
//		model.addAttribute("board", board);
//		return "getBoard";
		
		// STS container does everything else
	//	public ModelAndView getBoard(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Search function");
//
//		// 1. get article number
//		String sequence = request.getParameter("sequence");
//
//		// 2. manage DB
//		BoardVO vo = new BoardVO();
//		vo.setSequence(Integer.parseInt(sequence));
//
//		BoardDAO boardDAO = new BoardDAO();
//		BoardVO board = boardDAO.getBoard(vo);
//
//		ModelAndView mav = new ModelAndView();
//		// 3. get response view
//		mav.addObject("board", board);
//		// getBoard added by view resolver and not redirected
//		mav.setViewName("getBoard");
//		return mav;
//	}
//
//}
