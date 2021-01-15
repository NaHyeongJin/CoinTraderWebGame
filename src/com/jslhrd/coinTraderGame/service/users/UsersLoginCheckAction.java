package com.jslhrd.coinTraderGame.service.users;

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

public class UsersLoginCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_login_check.jsp");
		rd.forward(request, response);
	}
}