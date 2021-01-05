package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.coin.CoinDAO;
import com.jslhrd.coinTraderGame.model.coin.CoinVO;

@WebServlet("/CurrentPrice")
public class CurrentPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CurrentPrice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinGenerator manager = CoinGenerator.getInstance();
        manager.run();
        Gson gson = new GsonBuilder().create();
        CoinVO vo = new CoinVO();
        int[][] prices = manager.getCoinPrices();
        vo.setCoin1(prices[0]);
        vo.setCoin2(prices[1]);
        vo.setCoin3(prices[2]);
        vo.setCoin4(prices[3]);
        vo.setLastUpdateDate(CoinDAO.getInstance().coinUpdateDate());
        String json = gson.toJson(vo);
        response.setHeader("Content-Type", "application/json");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
