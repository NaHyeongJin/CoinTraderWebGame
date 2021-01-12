package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersPwSearchProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email1 = request.getParameter("email");
		String email2 = request.getParameter("emailSelect");
		int row = (UserDAO.getInstance().emailCheck(email1, email2) == null) ? 0 : 1;
		
		request.setAttribute("row", row);
		request.setAttribute("email", email1 + "@" + email2);
		if (row == 1) {
			// 비밀번호 임시 비밀번호로 변경해주고 getInstance().userModify(id, pw);
			// email로 전송
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_pw_search_pro.jsp");
		rd.forward(request, response);
	}
}