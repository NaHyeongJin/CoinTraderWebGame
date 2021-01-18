package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersIdSearchProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email1 = request.getParameter("email");
		String email2 = request.getParameter("emailSelect");
		
		String id = UserDAO.getInstance().emailCheck(email1, email2);
		request.setAttribute("row", (id == null) ? 0 : 1);
		request.setAttribute("email", email1 + "@" + email2);
		request.setAttribute("idCheck", id);
		RequestDispatcher rd = request.getRequestDispatcher("users/user_id_search_pro.jsp");
		rd.forward(request, response);
	}
}