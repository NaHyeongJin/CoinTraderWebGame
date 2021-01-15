package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.util.EmailModel;

public class CoinListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/coin/coin_list.jsp");
		String uri;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (UserDAO.getInstance().loginCheck(id)) {
			uri = "coin/coin_list.jsp";
		} else {
			UserVO vo = UserDAO.getInstance().getUser(id);
			String email = vo.getEmail1() + "@" + vo.getEmail2();
			UUID uuId = UUID.randomUUID();
			String authKey = uuId.toString().substring(0, 8);
			session.setAttribute("authKey", authKey);
			
			try {
				new EmailModel().send("[CoinTraderWebGame]이메일 인증 번호입니다.", email, "인증번호 : " + authKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			uri = "users/user_login_check.jsp";
		}
		
		rd = request.getRequestDispatcher(uri);

		rd.forward(request, response);
		
		//response.sendRedirect("coin/coin_list.jsp");
		

	


	}

}
