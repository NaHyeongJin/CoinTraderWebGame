package com.jslhrd.coinTraderGame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.service.Action;

@WebServlet("/qna")
public class QnaActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnaActionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = "";
		if (request.getParameter("cmd") != null) {
			cmd = request.getParameter("cmd");
		}
		request.getParameter("cmd");
		QnaActionFactory gf = QnaActionFactory.getInstance();
		Action action = gf.getAction(cmd);

		if (action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
