package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

//import com.jslhrd.coinTraderGame.model.users.UserVO;

public class UsersModifyAction implements Action {
	UserDAO dao = UserDAO.getInstance();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO manager = UserDAO.getInstance();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit.jsp");
		rd.forward(request, response);
		
	}
}
