package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.coin.CoinDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class CoinSell implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int timer = Integer.parseInt(request.getParameter("timer"));
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		if (id != null) {
			int amount = Integer.parseInt(request.getParameter("amount"));
			int sellprice = Integer.parseInt(request.getParameter("sellprice"));
			
			new Timer().schedule(new CoinSellAction(id, cnt, amount, sellprice), timer * 1000);
			
		}
		
		
		
	}

}
