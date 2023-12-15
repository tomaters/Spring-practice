package com.mirae.user.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirae.user.UserService;
import com.mirae.user.UserVO;

@Service("userService")
public class UserServiceImplement implements UserService {
	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}
}
