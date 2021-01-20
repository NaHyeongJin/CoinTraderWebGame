package com.jslhrd.coinTraderGame.service.ranking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.ranking.RankingDAO;
import com.jslhrd.coinTraderGame.model.ranking.RankingVO;

@WebServlet("/RankingListGet")
public class RankingListGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RankingListGet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new GsonBuilder().create();
		List<RankingVO> list = RankingDAO.getInstance().Ranking();
		String json = gson.toJson(list);
		response.setHeader("Content-Type", "application/json");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
