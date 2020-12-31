package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersModifyProAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		int row = UserDAO.getInstance().userModify(id, request.getParameter("pw1"));
		request.setAttribute("row", row);
		if (row == 1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(3600);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit_pro.jsp");
		rd.forward(request, response);
	}
}
