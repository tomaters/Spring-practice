package com.jam.timeline.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.jam.timeline.biz.common.JDBCUtil;
import com.jam.timeline.biz.user.UserVO;


@Repository("userDAO")
public class UserDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final String CREATE_USER = "INSERT INTO timeline_user (username, password, name, email, profpic_path) VALUES (?, ?, ?, ?, 'default_image.png')";
	private final String GET_USER = "SELECT * FROM timeline_user WHERE username=? AND password=?";
	private final String UPDATE_PROFPIC_PATH = "UPDATE timeline_user SET profpic_path =? WHERE username=?";
	private final String DELETE_ACCOUNT = "DELETE FROM timeline_user WHERE username=?";
	private final String VIEW_ACCOUNT = "SELECT * FROM timeline_user WHERE username=?";
	private final String CHECK_USERNAME = "SELECT * FROM timeline_user WHERE username=?";
	private final String UPDATE_USER = "UPDATE timeline_user SET username=?, password=?, name=?, email=? WHERE username=?";
	
	public void createAccount(UserVO userVO) {
		System.out.println("UserDAO userVO: " + userVO.getUsername() + " " + userVO.getPassword() + " " + userVO.getName() + " " + userVO.getEmail() + " " + userVO.getEmail() + " " + userVO.getProfpic_path());
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(CREATE_USER);
			preparedStatement.setString(1, userVO.getUsername());
			preparedStatement.setString(2, userVO.getPassword());
			preparedStatement.setString(3, userVO.getName());
			preparedStatement.setString(4, userVO.getEmail());
			// date is inserted as default SYSDATE
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
		System.out.println("createUser() processed");
	}
	
	public UserVO login(UserVO userVO) {
		UserVO user = null;
		System.out.println("UserDAO login: " + userVO.getUsername() + " " + userVO.getPassword());
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(GET_USER);
			preparedStatement.setString(1, userVO.getUsername());
			preparedStatement.setString(2, userVO.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new UserVO();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setReg_date(resultSet.getDate("reg_date"));
				user.setProfpic_path(resultSet.getString("profpic_path"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		} return user;
	}
	
	public void setProfpicPath(UserVO userVO) {
		try {
			System.out.println(userVO.getProfpic_path()+", " + userVO.getUsername());
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_PROFPIC_PATH);
			preparedStatement.setString(1, userVO.getProfpic_path());
			preparedStatement.setString(2, userVO.getUsername());		
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet,  preparedStatement, connection);
		}
	}
	
	public void deleteAccount(UserVO userVO) {
		System.out.println("deleteAccount() called");
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_ACCOUNT);
			preparedStatement.setString(1, userVO.getUsername());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		}
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
				user.setUsername(resultSet.getString("id"));
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet,  preparedStatement, connection);
		} return user;
	}
	
	public boolean checkUsername(String username) {
		System.out.println("checkUsername() called");
		boolean usernameExists = false;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(CHECK_USERNAME);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				usernameExists = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, preparedStatement, connection);
		} 
		return usernameExists;
	}
	
	public void updateUser(UserVO userVO, String previousUsername) {
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, userVO.getUsername());
			preparedStatement.setString(2, userVO.getPassword());
			preparedStatement.setString(3, userVO.getEmail());
			preparedStatement.setString(4, userVO.getName());
			preparedStatement.setString(5, previousUsername);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(preparedStatement, connection);
		} 
	}
}