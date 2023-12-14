package com.mirae.board.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirae.board.BoardService;
import com.mirae.board.BoardVO;

@Service("boardServiceImplement")
public class BoardServiceImplement implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
		
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		boardDAO.deleteBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		return boardDAO.getBoard(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		return boardDAO.getBoardList(boardVO);
	}
	
}
