//package com.mirae.spring.controller.board;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.mirae.biz.board.BoardVO;
//import com.mirae.biz.board.implement.BoardDAO;
//
//@Controller
//public class GetBoardListController {

	// transferred to BoardController
//	@RequestMapping(value="/getBoardList.do")
//	public String getBoardList(BoardVO boardVO, BoardDAO boardDAO, Model model) {
//		System.out.println("getBoardList()");
//		List<BoardVO> boardList = boardDAO.getBoardList(boardVO);
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//	}
	
	// STS container does everything else
//	public ModelAndView getBoardList(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Process get board list");
//
//		// 1. get info
//		// 2. manage DB
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//
//		// 3. get response view
//		ModelAndView mav = new ModelAndView();
//		// add to request; forward
//		mav.addObject("boardList", boardList);
//		// view resolver append
//		mav.setViewName("getBoardList");
//		return mav;
//	}
//}
