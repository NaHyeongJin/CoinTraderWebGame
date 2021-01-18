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

public class UserWithdrawalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		String id = request.getParameter("withdrawal_id");
		String pw = new PasswordEncoder().encode(request.getParameter("withdrawal_pw"));
		int row = dao.Withdrawal(id, pw);
		
		if(row==1) {
		HttpSession session = request.getSession();
		session.removeAttribute("withdrawal_id");
		session.invalidate();
		}
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("users/user_withdrawal.jsp");
		rd.forward(request, response);
	}

}
