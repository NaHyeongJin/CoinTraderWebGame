package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;

public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_delete.jsp");
		rd.forward(request, response);
		
	}

}
