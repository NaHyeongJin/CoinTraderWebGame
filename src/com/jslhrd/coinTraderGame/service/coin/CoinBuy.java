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

public class CoinBuy implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.global;
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		if (id != null) {
			Integer cnt = Integer.parseInt(request.getParameter("cnt"));
			Integer amount = Integer.parseInt(request.getParameter("amount"));
			Integer price = Integer.parseInt(request.getParameter("price"));
			CoinDAO.getInstance().coinBuy(id, cnt, amount, price); // id가 cnt번째 코인을 price가격으로 amount만큼 삼
			
			
		}
		
		
		
	}

}
