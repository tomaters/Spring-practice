package com.mirae.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) beanFactory.getBean("boardServiceImplement");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test_title");
		boardVO.setUsername("test_username");
		boardVO.setContent("test_content");
		boardService.insertBoard(boardVO);
		
		List<BoardVO> boardList = boardService.getBoardList(boardVO);
		for(BoardVO board : boardList) {
			System.out.println("Board: "+ board.toString());
		}
		beanFactory.close();
	}
}
