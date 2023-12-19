package com.mirae.biz.board.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mirae.biz.board.BoardVO;
import com.mirae.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// SQL statements
	private final String BOARD_INSERT = "INSERT INTO myboard(sequence, title, username, content) VALUES ((SELECT NVL(MAX(sequence), 0)+1 FROM myboard), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE myboard SET title=?, content=? where sequence=?";
	private final String BOARD_DELETE = "DELETE FROM myboard WHERE sequence=?";
	private final String BOARD_GET = "SELECT * FROM myboard WHERE sequence=?";
	private final String BOARD_LIST = "SELECT * FROM myboard ORDER BY sequence DESC";

	// insert method
	public void insertBoard(BoardVO boardVO) {
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
	public void updateBoard(BoardVO boardVO) {
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
	public void deleteBoard(BoardVO boardVO) {
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
	public BoardVO getBoard(BoardVO boardVO) {
		System.out.println("getBoard() called");
		BoardVO board = null;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_GET);
			preparedStatement.setInt(1, boardVO.getSequence());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				board = new BoardVO();
				board.setSequence(resultSet.getInt("SEQUENCE"));
				board.setTitle(resultSet.getString("TITLE"));
				board.setUsername(resultSet.getString("USERNAME"));
				board.setContent(resultSet.getString("CONTENT"));
				board.setRegDate(resultSet.getDate("REGDATE"));
				board.setCount(resultSet.getInt("COUNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		}
		return board;
	}

	// view board list method
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		System.out.println("getBoardList() called");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(BOARD_LIST);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BoardVO board = new BoardVO();
				board.setSequence(resultSet.getInt("SEQUENCE"));
				board.setTitle(resultSet.getString("TITLE"));
				board.setUsername(resultSet.getString("USERNAME"));
				board.setContent(resultSet.getString("CONTENT"));
				board.setRegDate(resultSet.getDate("REGDATE"));
				board.setCount(resultSet.getInt("COUNT"));
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