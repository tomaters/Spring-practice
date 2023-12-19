package com.mirae.biz.user.bimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.mirae.biz.common.JDBCUtil;
import com.mirae.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final String GET_USER = "SELECT * FROM users WHERE id=? AND password=?";
	private final String VIEW_ACCOUNT = "SELECT * FROM users WHERE id=?";
	private final String CREATE_USER = "INSERT INTO users VALUES(?, ?, ?, ?)";
			
	public UserVO getUser(UserVO userVO) {
		UserVO user = null;
		System.out.println(userVO.getId() + " " + userVO.getPassword());
		try {
			System.out.println("getUser() method called");
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(GET_USER);
			preparedStatement.setString(1, userVO.getId());
			preparedStatement.setString(2, userVO.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new UserVO();
				user.setId(resultSet.getString("id"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		} return user;
	}
	
	public void createUser(UserVO userVO) {
		System.out.println("UserDAO userVO: " + userVO.getId() + " " + userVO.getPassword() + " " + userVO.getName() + " " + userVO.getRole());
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(CREATE_USER);
			preparedStatement.setString(1, userVO.getId());
			preparedStatement.setString(2, userVO.getPassword());
			preparedStatement.setString(3, userVO.getName());
			preparedStatement.setString(4, userVO.getRole());
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
		System.out.println("createUser() processed");
	}	
	
	public UserVO viewAccount(String id) {
		UserVO user = null;
		System.out.println("viewAccount() method called");
		System.out.println("UserDAO id: " + id);
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(VIEW_ACCOUNT);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new UserVO();
				user.setId(resultSet.getString("id"));
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
				user.setRole(resultSet.getString("role"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet,  preparedStatement, connection);
		} return user;
	}
}