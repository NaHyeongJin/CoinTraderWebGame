package com.jslhrd.coinTraderGame.service.coin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.service.Action;

public class CoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coinname = request.getParameter("coinname");//코인종류
		if(coinname.contains("A코인")) {
			coinname="acoin";
		}else if(coinname.contains("B코인")) {
			coinname="bcoin";
		}else if(coinname.contains("C코인")) {
			coinname="ccoin";
		}else if(coinname.contains("D코인")) {
			coinname="dcoin";
		}
		String coinprice = request.getParameter("priceinput");//코인 개당 가격
		int buycoincnt = Integer.parseInt(request.getParameter("coincnt"));//구매한 코인수량
		int sellcoincnt = Integer.parseInt(request.getParameter("coincnt2"));//판매할 코인수량
		int selltime = Integer.parseInt(request.getParameter("selltime"));//판매할 시간
		
		
	}
}
