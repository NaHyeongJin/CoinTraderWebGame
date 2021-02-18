package com.jslhrd.coinTraderGame.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.service.Action;

@WebServlet("/receipt")
public class ReceiptActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiptActionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = "";
		if (request.getParameter("cmd") != null) {
			cmd = request.getParameter("cmd");
		}
		ReceiptActionFactory rf = ReceiptActionFactory.getInstance();
		Action action = rf.getAction(cmd);

		if (action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
