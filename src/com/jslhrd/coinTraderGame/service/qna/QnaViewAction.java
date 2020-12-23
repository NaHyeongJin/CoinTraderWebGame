package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QnaDAO dao = QnaDAO.getInstance();
		//페이지 처리
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		QnaVO vo = dao.QnaView(request.getParameter("id"));
		
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_view.jsp");
		rd.forward(request, response);

	}

}
