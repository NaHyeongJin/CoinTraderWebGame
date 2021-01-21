package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.receipt.ReceiptListAction;

public class ReceiptActionFactory {
	private static ReceiptActionFactory instance = new ReceiptActionFactory();
	
	public static ReceiptActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("receipt_list")) {
			action = new ReceiptListAction();
		}
		return action;
	}
}
