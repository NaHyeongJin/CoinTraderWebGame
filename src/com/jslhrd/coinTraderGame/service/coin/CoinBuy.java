package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.coin.CoinDAO;

@WebServlet("/CoinBuy")
public class CoinBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoinBuy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id != null) {
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int price = Integer.parseInt(request.getParameter("price"));
			CoinDAO.getInstance().coinBuy(id, cnt, amount, price); // id가 cnt번째 코인을 price가격으로 amount만큼 삼
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
