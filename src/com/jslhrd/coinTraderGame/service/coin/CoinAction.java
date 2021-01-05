package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.service.Action;

public class CoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coinname = request.getParameter("coinname");//코인종류
		if(coinname.contains("A코인")) {
			coinname="a";
		}else if(coinname.contains("B코인")) {
			coinname="b";
		}else if(coinname.contains("C코인")) {
			coinname="c";
		}else if(coinname.contains("D코인")) {
			coinname="d";
		}
		int coinprice = Integer.parseInt(request.getParameter("priceinput"));//코인 개당 가격
		int buycoincnt = Integer.parseInt(request.getParameter("coincnt"));//구매한 코인수량
		int sellcoincnt = Integer.parseInt(request.getParameter("coincnt2"));//판매할 코인수량
		int selltime = Integer.parseInt(request.getParameter("selltime"));//판매할 시간
		HttpSession session = request.getSession(true);
		String loginid= "";
		if(session.isNew()) {
			response.sendRedirect("user?cmd=sign_up");//세션없을시 다시 로그인페이지 유도
		}else {
			loginid = (String)session.getAttribute("id");//로그인아이디
		}
		
	}
}
