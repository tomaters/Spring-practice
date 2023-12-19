package com.mirae.controller;

import java.util.HashMap;
import java.util.Map;

import com.mirae.controller.board.DeleteBoardController;
import com.mirae.controller.board.GetBoardController;
import com.mirae.controller.board.GetBoardListController;
import com.mirae.controller.board.InsertBoardController;
import com.mirae.controller.board.LoginController;
import com.mirae.controller.board.LogoutController;
import com.mirae.controller.board.UpdateBoardController;
import com.mirae.controller.user.CreateAccountController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	// will automatically construct all HashMaps upon initialization
	public HandlerMapping() {
		super();
		// Board
		mappings = new HashMap<String, Controller>();
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		// User
		mappings.put("/createAccount.do", new CreateAccountController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
