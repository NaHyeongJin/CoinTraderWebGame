package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.users.UsersModifyAction;
import com.jslhrd.coinTraderGame.service.users.UsersModifyProAction;

public class UserActionFactory {
	private static UserActionFactory instance = new UserActionFactory();
	public static UserActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("user_edit")) {
			action = new UsersModifyAction();
		}else if(cmd.equals("user_edit_pro")) {
			action = new UsersModifyProAction();
		}
		return action;
	}
}
