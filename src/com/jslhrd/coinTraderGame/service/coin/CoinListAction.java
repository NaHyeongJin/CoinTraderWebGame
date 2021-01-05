package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.service.Action;

public class CoinListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("coin/coin_list.jsp");
		

	}

}
