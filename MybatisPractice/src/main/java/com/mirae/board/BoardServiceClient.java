package com.mirae.board;

import java.util.List;

import com.mirae.board.biz.BoardVO;
import com.mirae.board.biz.impl.BoardDAO;

public class BoardServiceClient {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("abc");
		boardVO.setUsername("def");
		boardVO.setContent("ghi");
        boardDAO.insertBoard(boardVO);
        boardVO.setSearchCondition("jkl");
        boardVO.setSearchKeyword("mno");
        List<BoardVO> boardList = boardDAO.getBoardList(boardVO);
        for (BoardVO board : boardList) {
            System.out.println("——> " + board.toString());
        }
    }
}