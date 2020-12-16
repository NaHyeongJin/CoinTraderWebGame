package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;

public class UserActionFactory {
	private static UserActionFactory instance = new UserActionFactory();
	public static UserActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("user")) {
			action = new UsersModifyAction();
			System.out.println("정보수정 성공");
		}else if(cmd != null) {
			
		}
		return action;
	}
}
