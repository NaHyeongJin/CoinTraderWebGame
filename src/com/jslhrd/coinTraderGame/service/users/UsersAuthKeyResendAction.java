package com.jslhrd.coinTraderGame.service.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.util.EmailModel;

public class UsersAuthKeyResendAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		UserVO vo = UserDAO.getInstance().getUser(id);
		String email = vo.getEmail1() + "@" + vo.getEmail2();
		UUID uuId = UUID.randomUUID();
		String authKey = uuId.toString().substring(0, 8);
		int row = 0;
		
		try {
			new EmailModel().send("[CoinTraderWebGame]이메일 인증 번호입니다.", email, "인증번호 : " + authKey);
			session.setAttribute("authKey", authKey);
			row = 1;
		} catch (Exception e) {
			row = 0;
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(row);
		response.setHeader("Content-Type", "application/json");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
	}

}
