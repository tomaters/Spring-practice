package com.mirae.biz.board.implement;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mirae.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// insert method
	public void insertBoard(BoardVO boardVO) {
		System.out.println("Mybatis insertBoard()");
		mybatis.insert("boardDAO.insertBoard", boardVO);
	}

	// edit method
	public void updateBoard(BoardVO boardVO) {
		System.out.println("Mybatis updateBoard()");
		mybatis.update("boardDAO.updateBoard", boardVO);
	}

	// delete method
	public void deleteBoard(BoardVO boardVO) {
		System.out.println("Mybatis deleteBoard()");
		mybatis.delete("boardDAO.deleteBoard", boardVO);
	}

	// view board method
	public BoardVO getBoard(BoardVO boardVO) {
		System.out.println("Mybatis getBoard()");
		return mybatis.selectOne("boardDAO.getBoard", boardVO);
	}

	// view board list method
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		System.out.println("Mybatis getBoardList(): " + boardVO.getSearchCondition());
		if(boardVO.getSearchCondition().equals(null)) {
			boardVO.setContent("");
		}
		switch(boardVO.getSearchCondition()) {
		case "title": return mybatis.selectList("boardDAO.searchTitle", boardVO);
		case "username": return mybatis.selectList("boardDAO.searchUsername", boardVO);
		case "content": return mybatis.selectList("boardDAO.searchContent", boardVO);
		default: return mybatis.selectList("boardDAO.getBoardList", boardVO);
		}
	}
}