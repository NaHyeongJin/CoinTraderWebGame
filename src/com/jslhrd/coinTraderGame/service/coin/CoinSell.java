package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CoinSell")
public class CoinSell extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CoinSell() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int timer = Integer.parseInt(request.getParameter("timer"));
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id != null) {
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int price = Integer.parseInt(request.getParameter("price"));
			new Timer().schedule(new CoinSellAction(id, cnt, amount, price), timer * 1000);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
