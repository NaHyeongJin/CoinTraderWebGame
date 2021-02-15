package com.jslhrd.coinTraderGame.service.receipt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.receipt.ReceiptDAO;
import com.jslhrd.coinTraderGame.service.Action;

public class ReceiptSearchListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReceiptDAO dao = ReceiptDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		
		int currentPage = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
		int startpage = (currentPage - 1) * 20;
		int endpage = startpage + 21;
		
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		
		request.setAttribute("startday", startday);
		request.setAttribute("endday", endday);
		request.setAttribute("vo", ReceiptDAO.getInstance().ReceiptList((String) session.getAttribute("id"), startpage, endpage, startday, endday));
		request.setAttribute("list", dao.ReceiptList(id, startpage, endpage, startday, endday));
		request.setAttribute("totpage", ((dao.ReceiptCount(id, startday, endday) - 1) / 20) + 1);
		request.setAttribute("currentPage", currentPage);
		RequestDispatcher rd = request.getRequestDispatcher("receipt/receipt_search_list.jsp");
		rd.forward(request, response);

	}

}
