package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;

@WebServlet("/UserGetMoney")
public class UserGetMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserGetMoney() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if (id != null) {
			Gson gson = new GsonBuilder().create();
			int money = UserDAO.getInstance().getUserMoney(id);
			String json = gson.toJson(money);
			response.setHeader("Content-Type", "application/json");
	        PrintWriter pw = response.getWriter();
	        pw.print(json);
	        pw.flush();
	        pw.close();
	        
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
