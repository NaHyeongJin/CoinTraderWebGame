package com.jslhrd.coinTraderGame.controller;

import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.service.qna.QnaAnswerAction;
import com.jslhrd.coinTraderGame.service.qna.QnaAnswerProAction;
import com.jslhrd.coinTraderGame.service.qna.QnaDeleteProAction;
import com.jslhrd.coinTraderGame.service.qna.QnaListAction;
import com.jslhrd.coinTraderGame.service.qna.QnaModifyAction;
import com.jslhrd.coinTraderGame.service.qna.QnaModifyProAction;
import com.jslhrd.coinTraderGame.service.qna.QnaViewAction;
import com.jslhrd.coinTraderGame.service.qna.QnaWriteAction;
import com.jslhrd.coinTraderGame.service.qna.QnaWriteProAction;

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
			action = new QnaModifyAction();
		}else if(cmd.equals("qna_answer")) {
			action = new QnaAnswerAction();
		}else if(cmd.equals("qna_write_pro")) {
			action = new QnaWriteProAction();
		}else if(cmd.equals("qna_modify_pro")) {
			action = new QnaModifyProAction();
		}else if(cmd.equals("qna_delete_pro")) {
			action = new QnaDeleteProAction();
		}else if(cmd.equals("qna_answer_pro")) {
			action = new QnaAnswerProAction();
		}
		return action;
	}
}