package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.filter.PasswordEncoder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersModifyProAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		int row = UserDAO.getInstance().userModify(id, new PasswordEncoder().encode(request.getParameter("pw1")));
		if (row == 1) {
			UserDAO.getInstance().setPwCheck(id, 1);
		}
		request.setAttribute("row", row);

		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit_pro.jsp");
		rd.forward(request, response);
	}
}
