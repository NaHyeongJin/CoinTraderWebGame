package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.users.UsersAuthKeyCheckAction;
import com.jslhrd.coinTraderGame.service.users.UsersAuthKeyResendAction;
import com.jslhrd.coinTraderGame.service.users.UsersIdSearchAction;
import com.jslhrd.coinTraderGame.service.users.UsersIdSearchProAction;
import com.jslhrd.coinTraderGame.service.users.UsersLoginAction;
import com.jslhrd.coinTraderGame.service.users.UsersLoginCheckAction;
import com.jslhrd.coinTraderGame.service.users.UsersLogoutAction;
import com.jslhrd.coinTraderGame.service.users.UsersModifyAction;
import com.jslhrd.coinTraderGame.service.users.UsersModifyProAction;
import com.jslhrd.coinTraderGame.service.users.UsersPwSearchAction;
import com.jslhrd.coinTraderGame.service.users.UsersPwSearchProAction;
import com.jslhrd.coinTraderGame.service.users.UsersSignUpAction;
import com.jslhrd.coinTraderGame.service.users.UsersSignUpProAction;

public class UserActionFactory {
	private static UserActionFactory instance = new UserActionFactory();

	public static UserActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("user_edit")) {
			action = new UsersModifyAction();
		} else if (cmd.equals("user_edit_pro")) {
			action = new UsersModifyProAction();
		} else if (cmd.equals("login")) {
			action = new UsersLoginAction();
		} else if (cmd.equals("logout")) {
			action = new UsersLogoutAction();
		} else if (cmd.equals("sign_up")) {
			action = new UsersSignUpAction();
		} else if (cmd.equals("sign_up_pro")) {
			action = new UsersSignUpProAction();
		} else if (cmd.equals("id_search")) {
			action = new UsersIdSearchAction();
		} else if (cmd.equals("pw_search")) {
			action = new UsersPwSearchAction();
		} else if (cmd.equals("id_search_pro")) {
			action = new UsersIdSearchProAction();
		} else if (cmd.equals("pw_search_pro")) {
			action = new UsersPwSearchProAction();
		} else if (cmd.equals("login_check")) {
			action = new UsersLoginCheckAction();
		} else if (cmd.equals("auth_key_resend")) {
			action = new UsersAuthKeyResendAction();
		} else if (cmd.equals("auth_key_check")) {
			action = new UsersAuthKeyCheckAction();
		}
		return action;
	}
}
