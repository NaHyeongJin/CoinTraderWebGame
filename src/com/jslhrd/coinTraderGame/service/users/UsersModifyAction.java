package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("vo", UserDAO.getInstance().getUser((String) session.getAttribute("id")));
		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit.jsp");
		rd.forward(request, response);
	}
}
