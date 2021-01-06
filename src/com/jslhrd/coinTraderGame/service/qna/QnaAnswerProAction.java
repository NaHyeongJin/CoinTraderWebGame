package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;

public class QnaAnswerProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QnaDAO dao = QnaDAO.getInstance();
		QnaVO vo = new QnaVO();
		vo.setAnswer(request.getParameter("answer"));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		int row = dao.QnaAnswer(vo);
		
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_answer_pro.jsp");
		rd.forward(request, response);
	}

}
