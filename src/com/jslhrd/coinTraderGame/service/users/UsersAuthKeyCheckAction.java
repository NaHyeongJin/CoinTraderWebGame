package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersAuthKeyCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int row = (request.getParameter("emailCheck").equals((String) session.getAttribute("authKey"))) ? 1 : 0;
		request.setAttribute("row", row);
		if (row == 1) {
			UserDAO.getInstance().authSuccess((String) session.getAttribute("id"));
			session.removeAttribute("authKey");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_login_check_pro.jsp");
		rd.forward(request, response);
	}

}
