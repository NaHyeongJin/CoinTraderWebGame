package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.coin.CoinAction;
import com.jslhrd.coinTraderGame.service.coin.CoinListAction;

public class CoinActionFactory{

	private static CoinActionFactory instance = new CoinActionFactory();
	public static CoinActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equalsIgnoreCase("coin_buy")) {
			action = new CoinAction();
		}else if(cmd.equalsIgnoreCase("coin_list")) {
			action= new CoinListAction();
		}
		return action;
	}

}
