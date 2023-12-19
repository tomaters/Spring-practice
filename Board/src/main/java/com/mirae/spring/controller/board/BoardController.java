package com.mirae.spring.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.board.implement.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO boardVO, BoardDAO boardDAO) {
		System.out.println("deleteBoard()");
		boardDAO.deleteBoard(boardVO);
		return "getBoardList";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO boardVO, BoardDAO boardDAO, Model model) {
		System.out.println("getBoard()");
		BoardVO board = boardDAO.getBoard(boardVO);
		model.addAttribute("board", board);
		return "getBoard";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO boardVO, BoardDAO boardDAO, Model model) {
		System.out.println("getBoardList()");
		List<BoardVO> boardList = boardDAO.getBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardDAO boardDAO, BoardVO boardVO) {
		System.out.println("insertBoard()");
		boardDAO.insertBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardDAO boardDAO, BoardVO boardVO) {
		System.out.println("updateBoard()");
		boardDAO.updateBoard(boardVO);
		return "redirect:getBoardList.do";
	}
}