package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;

public class QnaModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QnaDAO dao = QnaDAO.getInstance();

		QnaVO vo = dao.QnaView(request.getParameter("id"), Integer.parseInt(request.getParameter("idx")));
		vo.setContents(vo.getContents().replace("\n", "<br>"));

		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_modify.jsp");
		rd.forward(request, response);
	}

}
