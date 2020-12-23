package com.jslhrd.coinTraderGame.service.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.qna.QnaDAO;
import com.jslhrd.coinTraderGame.model.qna.QnaVO;
import com.jslhrd.coinTraderGame.service.Action;
import com.jslhrd.coinTraderGame.util.PageIndex;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QnaDAO dao = QnaDAO.getInstance();
		String url = "qna?cmd=qna_list";
		
		String query="", key="", s_query="";
		int totcount = 0;	// 전체 게시물 건수 계산
		if(request.getParameter("key") !=null && !request.getParameter("key").equals("")) {
			query=request.getParameter("search");
			key = request.getParameter("key");
			s_query= query + " like '%" + key+ "%'";
			totcount = dao.QnaCount(s_query);
			
		}else {
			//검색 없을 시 총 갯수
			totcount = dao.QnaCount();
		}
		int nowpage = 1;	// 현재 페이지 초기화
		int maxlist = 5;	// 페이지당 게시글 수 초기화
		int totpage = 1;	// 전체 페이지 초기화
		
		// 총 페이지수 계산
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		}else {
			totpage = totcount / maxlist + 1;
		}
		//내용이 없을때 페이지를 1페이지로 만듦
		if(totpage==0)
			totpage=1;
		
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if(nowpage>totpage) {
			nowpage = totpage;
		}
		//시작, 끝 페이지 계산
		int startpage = totcount - nowpage*maxlist + 1;
		int endpage = startpage + maxlist - 1;
		int listcount = totcount-((nowpage-1)*maxlist);
		
		List<QnaVO> list = null;
		if(key.equals("")) {
			list = dao.QnaList(startpage, endpage);
		}else {
			list = dao.QnaList(s_query, startpage, endpage);
		}

		
		
		// 페이지 처리
		String pageSkip = "";
		pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		}else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, query, key);
		}
		request.setAttribute("page", nowpage);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("query", query);
		request.setAttribute("totcount", totcount);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("qna/qna_list.jsp");
		rd.forward(request, response);
		
	}

}
