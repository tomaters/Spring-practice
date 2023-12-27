package com.mirae.biz.board.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mirae.biz.board.BoardVOBU;
import com.mirae.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// SQL statements
	private final String BOARD_INSERT = "INSERT INTO myboard(sequence, title, username, content) VALUES ((SELECT NVL(MAX(sequence), 0)+1 FROM myboard), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE myboard SET title=?, content=? WHERE sequence=?";
	private final String BOARD_DELETE = "DELETE FROM myboard WHERE sequence=?";
	private final String BOARD_GET = "SELECT * FROM myboard WHERE sequence=?";
	private final String BOARD_LIST = "SELECT * FROM myboard ORDER BY sequence DESC";
	private final String BOARD_LIST_SEARCH_TITLE = "SELECT * FROM myboard WHERE title like '%' || ? || '%' ORDER BY sequence DESC";
	private final String BOARD_LIST_SEARCH_USERNAME = "SELECT * FROM myboard WHERE username like '%' || ? || '%' ORDER BY sequence DESC";
	private final String BOARD_LIST_SEARCH_CONTENT = "SELECT * FROM myboard WHERE content like '%' || ? || '%' ORDER BY sequence DESC";

	// insert method
	public void insertBoard(BoardVOBU boardVO) {
		System.out.println("insertBoard() called");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_INSERT);
			preparedStatement.setString(1, boardVO.getTitle());
			preparedStatement.setString(2, boardVO.getUsername());
			preparedStatement.setString(3, boardVO.getContent());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	// edit method
	public void updateBoard(BoardVOBU boardVO) {
		System.out.println("updateBoard() called");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_UPDATE);
			preparedStatement.setString(1, boardVO.getTitle());
			preparedStatement.setString(2, boardVO.getContent());
			preparedStatement.setInt(3, boardVO.getSequence());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	// delete method
	public void deleteBoard(BoardVOBU boardVO) {
		System.out.println("deleteBoard() called");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_DELETE);
			preparedStatement.setInt(1, boardVO.getSequence());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
	}

	// view board method
	public BoardVOBU getBoard(BoardVOBU boardVO) {
		System.out.println("getBoard() called");
		BoardVOBU board = null;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_GET);
			preparedStatement.setInt(1, boardVO.getSequence());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				board = new BoardVOBU();
				board.setSequence(resultSet.getInt("sequence"));
				board.setTitle(resultSet.getString("title"));
				board.setUsername(resultSet.getString("username"));
				board.setContent(resultSet.getString("content"));
				board.setRegDate(resultSet.getDate("regdate"));
				board.setCount(resultSet.getInt("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}
		return board;
	}

	// view board list method
	public List<BoardVOBU> getBoardList(BoardVOBU boardVO) {
		System.out.println("getBoardList() called");
		List<BoardVOBU> boardList = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			if(boardVO.getSearchCondition().equals("title")) {
				System.out.println(boardVO.getSearchCondition());
				preparedStatement = connection.prepareStatement(BOARD_LIST_SEARCH_TITLE);
				preparedStatement.setString(1, boardVO.getSearchKeyword());
			}
			else if(boardVO.getSearchCondition().equals("username")) {
				preparedStatement = connection.prepareStatement(BOARD_LIST_SEARCH_USERNAME);
				preparedStatement.setString(1, boardVO.getSearchKeyword());
			}
			else if(boardVO.getSearchCondition().equals("content")) {
				preparedStatement = connection.prepareStatement(BOARD_LIST_SEARCH_CONTENT);
				preparedStatement.setString(1, boardVO.getSearchKeyword());
			}
			else {
				preparedStatement = connection.prepareStatement(BOARD_LIST);
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BoardVOBU board = new BoardVOBU();
				board.setSequence(resultSet.getInt("sequence"));
				board.setTitle(resultSet.getString("title"));
				board.setUsername(resultSet.getString("username"));
				board.setContent(resultSet.getString("content"));
				board.setRegDate(resultSet.getDate("regdate"));
				board.setCount(resultSet.getInt("count"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}
		return boardList;
	}
}