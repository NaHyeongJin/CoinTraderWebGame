package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.filter.PasswordEncoder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		int gocoin = Integer.parseInt(request.getParameter("gocoin"));
		int row = UserDAO.getInstance().userLogin(id, request.getParameter("pw"));
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("users/user_login_pro.jsp");

		row = UserDAO.getInstance().userLogin(id, new PasswordEncoder().encode(request.getParameter("pw")));
		request.setAttribute("row", row);
		request.setAttribute("loginCheck", UserDAO.getInstance().loginCheck(id));
		request.setAttribute("pwCheck", UserDAO.getInstance().pwCheck(id));

		if (row == 1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(3600);
			if(gocoin==1) {
				rd=request.getRequestDispatcher("coin?cmd=coin_list");
			}
		}
		rd.forward(request, response);
	}
}