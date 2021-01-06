package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.util.PageIndex;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QnaDAO dao = QnaDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int currentPage = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
		int startpage = (currentPage-1)*10;
		int endpage = startpage + 11;
		
		request.setAttribute("list", (id.contains("admin") ? dao.QnaList(startpage, endpage) : dao.QnaList(id, startpage, endpage)));
		request.setAttribute("totpage", (id.contains("admin")) ? ((dao.QnaCount()-1)/10)+1 : ((dao.QnaCount(id)-1)/10)+1);
		request.setAttribute("currentPage", currentPage);
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_list.jsp");
		rd.forward(request, response);
	}
}
