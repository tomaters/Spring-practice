package com.mirae.board.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mirae.board.biz.BoardVO;
import com.mirae.board.biz.util.SqlSessionBeanFactory;

public class BoardDAO {
    private SqlSession mybatis;

    public BoardDAO() {
        mybatis = SqlSessionBeanFactory.getSqlSessionInstance();
    }

    public void insertBoard(BoardVO vo) {
        mybatis.insert("boardDAO.insertBoard", vo);
        mybatis.commit();
    }

    public void updateBoard(BoardVO vo) {
        mybatis.update("boardDAO.updateBoard", vo);
        mybatis.commit();
    }

    public void deleteBoard(BoardVO vo) {
        mybatis.delete("boardDAO.deleteBoard", vo);
        mybatis.commit();
    }

    public BoardVO getBoard(BoardVO vo) {
        return (BoardVO)mybatis.selectOne("boardDAO.getBoard", vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        return mybatis.selectList("boardDAO.getBoardList", vo);
    }
}
