package com.jslhrd.coinTraderGame.service.receipt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.receipt.ReceiptDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class ReceiptListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("vo", ReceiptDAO.getInstance().getReceipt((String) session.getAttribute("id")));
		
		RequestDispatcher rd = request.getRequestDispatcher("receipt/receipt_list.jsp");
		rd.forward(request, response);
	}

}
