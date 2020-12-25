package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.coin.CoinDAO;

@WebServlet("/CurrentPrice")
public class CurrentPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CurrentPrice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinGenerator manager = CoinGenerator.getInstance();
        new Timer().scheduleAtFixedRate(manager, 0, 60000); // ���� �������� 1�� �������� ���� DB�� ��������
        // ������ �̰� 1�� �������� get�� �Ѵٸ� ���� Ÿ�̸Ӵ� �ʿ� ��������?
        // �׳� ���⿡ manager.run() �����ϸ� �ɵ�
		request.setAttribute("coin1", manager.getCoinPrices()[0]);
		request.setAttribute("coin2", manager.getCoinPrices()[1]);
		request.setAttribute("coin3", manager.getCoinPrices()[2]);
		request.setAttribute("coin4", manager.getCoinPrices()[3]);
		request.setAttribute("lastUpdateDate", CoinDAO.getInstance().coinUpdateDate());
		RequestDispatcher dispatcher = request.getRequestDispatcher("coin/test.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
