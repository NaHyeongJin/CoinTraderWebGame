package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.qna.QnaAnswerAction;
import com.jslhrd.coinTraderGame.service.qna.QnaListAction;
import com.jslhrd.coinTraderGame.service.qna.QnaViewAction;
import com.jslhrd.coinTraderGame.service.qna.QnaWriteAction;

public class QnaActionFactory {
	private static QnaActionFactory instance = new QnaActionFactory();
	public static QnaActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("qna_list")) {
			action = new QnaListAction();
		}else if(cmd.equals("qna_view")) {
			action = new QnaViewAction();
		}else if(cmd.equals("qna_write")) {
			action = new QnaWriteAction();
		}else if(cmd.equals("qna_modify")) {
			action = new QnaWriteAction();
		}else if(cmd.equals("qna_delete")) {
			action = new QnaWriteAction();
		}else if(cmd.equals("qna_answer")) {
			action = new QnaAnswerAction();
		}
		return action;
	}
}
