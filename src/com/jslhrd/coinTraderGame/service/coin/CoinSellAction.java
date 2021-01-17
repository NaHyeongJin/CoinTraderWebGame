package com.jslhrd.coinTraderGame.service.coin;

import java.util.TimerTask;

import com.jslhrd.coinTraderGame.model.coin.CoinDAO;

public class CoinSellAction extends TimerTask {
	private String id;
	private int cnt, amount, price;

	public CoinSellAction(String id, int cnt, int amount, int price) {
		this.id = id;
		this.cnt = cnt;
		this.amount = amount;
		this.price = price;
	}

	@Override
	public void run() {
		CoinDAO.getInstance().coinSell(id, cnt, amount, price);
	}

}
