package com.jam.timeline.biz.user;

public interface UserService {

	void createAccount(UserVO userVO);
	void login(UserVO userVO);
	void logout(UserVO userVO);
	void submitProfpic(UserVO userVO);
	void deleteAccount(UserVO userVO);
	void updateAccount(UserVO userVO);
}
