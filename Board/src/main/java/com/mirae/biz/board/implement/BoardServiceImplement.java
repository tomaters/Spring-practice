package com.mirae.biz.board.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirae.biz.board.BoardService;
import com.mirae.biz.board.BoardVO;

@Service("boardServiceImplement")
public class BoardServiceImplement implements BoardService {
	@Autowired
	private BoardDAOMybatis boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		// PRE-BUSINESS LOGIC LOGGING
		
		// BUSINESS LOGIC
		boardDAO.insertBoard(boardVO);
		// toggle try-catch clause to invoke/revoke printLog4() after-throwing method
		if(boardVO.getSequence()==0) {
			try {
				throw new IllegalArgumentException("Error message");								
			} catch(IllegalArgumentException e) {}
		}
		
		// EXCEPTION HANDLING
		
		// TRANSACTION HANDLING
		
		// "POST-BUSINESS LOGIC LOGGING"
		
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
