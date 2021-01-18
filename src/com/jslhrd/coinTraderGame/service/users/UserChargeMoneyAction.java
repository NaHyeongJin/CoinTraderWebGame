package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UserChargeMoneyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		String id = request.getParameter("charge_id");
		int money = Integer.parseInt(request.getParameter("money"));
		int money2 = dao.ChargeMoney(money, id);
		
		request.setAttribute("money", money2);
		RequestDispatcher rd = request.getRequestDispatcher("users/user_chargemoney_pro.jsp");
		rd.forward(request, response);
	}

}
