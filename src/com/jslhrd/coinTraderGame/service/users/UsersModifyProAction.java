package com.jslhrd.coinTraderGame.service.users;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;
//import com.jslhrd.coinTraderGame.model.users.UserVO;
public class UsersModifyProAction implements Action {
	UserDAO dao = UserDAO.getInstance();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
//		회원정보 가져오는 메소드 추가 요망
//		로그아웃
//		request.setCharacterEncoding("utf-8");
//		HttpSession session = request.getSession();
//		session.removeAttribute("");
//		session.removeAttribute("");
//		session.invalidate();
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('로그아웃 성공');");
//		out.println("location.href='/index.jsp';");
//		out.println("</script>");
//		
		UserVO vo = new UserVO();
		vo.setPw(request.getParameter("pw1"));
		vo.setId(request.getParameter("user_id"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail2(request.getParameter("email2"));
		
		UserDAO dao = UserDAO.getInstance();
		int row = dao.UserModify(vo);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit_pro.jsp");
		rd.forward(request, response);
		
	}
}
