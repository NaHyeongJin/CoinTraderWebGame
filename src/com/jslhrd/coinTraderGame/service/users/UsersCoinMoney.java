package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;

@WebServlet("/UsersCoinMoney")
public class UsersCoinMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UsersCoinMoney() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	HttpSession session = request.getSession();
			Gson gson = new GsonBuilder().create();
			List list = new ArrayList();
	        list = UserDAO.getInstance().getMoneyList((String)session.getAttribute("id"));
	        String json = gson.toJson(list);
	        response.setHeader("Content-Type", "application/json");
	        PrintWriter pw = response.getWriter();
	        pw.print(json);
	        pw.flush();
	        pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
