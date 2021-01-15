package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.filter.PasswordEncoder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.util.EmailModel;

public class UsersPwSearchProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email1 = request.getParameter("email");
		String email2 = request.getParameter("emailSelect");
		String email = email1 + "@" + email2;
		
		String id = request.getParameter("id");
		
		int row = (UserDAO.getInstance().emailCheck(email1, email2).equals(id)) ? 1 : 0;
		
		request.setAttribute("row", row);
		request.setAttribute("email", email);
		
		if (row == 1) {
			UUID uuId = UUID.randomUUID();
			String pw = uuId.toString().substring(0, 8);
			UserDAO.getInstance().userModify(id, new PasswordEncoder().encode(pw));

			try {
				new EmailModel().send("[CoinTraderWebGame]임시 비밀번호입니다.", email, "임시 비밀번호 : " + pw);
				UserDAO.getInstance().setPwCheck(id, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_pw_search_pro.jsp");
		rd.forward(request, response);
	}
}