package com.jslhrd.coinTraderGame.service.receipt;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		request.setCharacterEncoding("utf-8");
		ReceiptDAO dao = ReceiptDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		DateFormat sf = new SimpleDateFormat ("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		String endday = sf.format(date);
		cal.add(Calendar.DATE, -7);
		String startday = sf.format(cal.getTime());
		
		int currentPage = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
		int startpage = (currentPage - 1) * 20;
		int endpage = startpage + 21;
		
		request.setAttribute("startday", startday);
		request.setAttribute("endday", endday);
		request.setAttribute("vo", ReceiptDAO.getInstance().ReceiptList((String) session.getAttribute("id"), startpage, endpage));
		request.setAttribute("list", dao.ReceiptList(id, startpage, endpage));
		request.setAttribute("totpage", ((dao.ReceiptCount(id) - 1) / 20) + 1);
		request.setAttribute("currentPage", currentPage);
		RequestDispatcher rd = request.getRequestDispatcher("receipt/receipt_list.jsp");
		rd.forward(request, response);
	}

}
