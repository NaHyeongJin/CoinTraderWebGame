package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class UserChargeMoneyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("row", UserDAO.getInstance().ChargeMoney(
				Integer.parseInt(request.getParameter("charge_money")), (String) session.getAttribute("id")));

		RequestDispatcher rd = request.getRequestDispatcher("users/user_chargemoney_pro.jsp");
		rd.forward(request, response);
	}

}
