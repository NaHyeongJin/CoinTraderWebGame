package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;

public class CoinListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String loginid= "";
		int money=0;
		UserVO uvo = new UserVO();
		if(session.isNew()) {
		}else {
			loginid = (String)session.getAttribute("id");//로그인아이디
			UserDAO udao = UserDAO.getInstance();
			uvo = udao.getUser(loginid);
			money=uvo.getMoney();
		}
		request.setAttribute("money", money);
		RequestDispatcher rd = request.getRequestDispatcher("/coin/coin_list.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("coin/coin_list.jsp");
		

	}

}
