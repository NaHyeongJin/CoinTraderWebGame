package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.receipt.ReceiptListAction;
import com.jslhrd.coinTraderGame.service.receipt.ReceiptSearchListAction;

public class ReceiptActionFactory {
	private static ReceiptActionFactory instance = new ReceiptActionFactory();
	
	public static ReceiptActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("receipt_list")) {
			action = new ReceiptListAction();
		}else if(cmd.equals("receipt_search")) {
			action = new ReceiptSearchListAction();
		}
		return action;
	}
}
