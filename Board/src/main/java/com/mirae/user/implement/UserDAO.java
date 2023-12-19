package com.mirae.user.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.mirae.common.JDBCUtil;
import com.mirae.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final String GET_USER = "SELECT * FROM users WHERE id=? AND password=?";
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
				user.setId(resultSet.getString("ID"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setName(resultSet.getString("NAME"));
				user.setRole(resultSet.getString("ROLE"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet,  preparedStatement, connection);
		} return user;
	}
	
	public void createUser(UserVO userVO) {
		System.out.println(userVO.getId() + " " + userVO.getPassword() + " " + userVO.getName() + " " + userVO.getRole());
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
}
