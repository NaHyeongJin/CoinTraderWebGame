package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersSignUpProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setEmail1(request.getParameter("email"));
		vo.setEmail2(request.getParameter("emailSelect"));
		
		request.setAttribute("row", UserDAO.getInstance().signUp(vo));
		RequestDispatcher rd = request.getRequestDispatcher("users/user_sign_up_pro.jsp");
		rd.forward(request, response);
	}
}