package com.mirae.biz.board.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mirae.biz.board.BoardVO;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	// insert method
	public void insertBoard(BoardVO boardVO) {
		System.out.println("JPA insertBoard()");
		em.persist(boardVO);
	}

	// edit method
	public void updateBoard(BoardVO boardVO) {
		System.out.println("JPA updateBoard()");
		em.merge(boardVO);
	}

	// delete method
	public void deleteBoard(BoardVO boardVO) {
		System.out.println("JPA deleteBoard()");
		BoardVO board = em.find(BoardVO.class, boardVO.getSequence());
		em.remove(board);
	}

	// view board method
	public BoardVO getBoard(BoardVO boardVO) {
		System.out.println("JPA getBoard()");
		return em.find(BoardVO.class, boardVO.getSequence());
	}

	// view board list method
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		System.out.println("JPA getBoardList(): " + boardVO.getSearchCondition());
		String jpasql = "select b from BoardVO b order by b.sequence";
		return em.createQuery(jpasql).getResultList();
//		if(boardVO.getSearchCondition().equals(null)) {
//			boardVO.setContent("");
//		}
//		switch(boardVO.getSearchCondition()) {
//		case "title": return em.selectList(boardVO);
//		case "username": return em.selectList(boardVO);
//		case "content": return em.selectList(boardVO);
//		default: return em.selectList("boardDAO.getBoardList", boardVO);
//		}
	}
}