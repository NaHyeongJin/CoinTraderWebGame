package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.coin.CoinBuy;
import com.jslhrd.coinTraderGame.service.coin.CoinListAction;
import com.jslhrd.coinTraderGame.service.coin.CoinSell;

public class CoinActionFactory {

	private static CoinActionFactory instance = new CoinActionFactory();

	public static CoinActionFactory getInstance() {
		return instance;
	};

	public Action getAction(String cmd) {
		Action action = null;

		if (cmd.equalsIgnoreCase("coin_list")) {
			action = new CoinListAction();
		} else if (cmd.equalsIgnoreCase("coin_buy")) {
			action = new CoinBuy();
		} else if (cmd.equalsIgnoreCase("coin_sell")) {
			action = new CoinSell();
		}
		return action;
	};

};
