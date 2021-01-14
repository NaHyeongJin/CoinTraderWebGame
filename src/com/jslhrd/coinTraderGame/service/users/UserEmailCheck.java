package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;

@WebServlet("/UserEmailCheck")
public class UserEmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new GsonBuilder().create();
		Boolean emailCheck = UserDAO.getInstance().isEmailAble((String) request.getParameter("email"), (String) request.getParameter("emailSelect"));
		String json = gson.toJson(emailCheck);
		response.setHeader("Content-Type", "application/json");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
