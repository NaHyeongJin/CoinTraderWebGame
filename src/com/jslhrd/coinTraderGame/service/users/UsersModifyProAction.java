package com.jslhrd.coinTraderGame.service.users;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;
//import com.jslhrd.coinTraderGame.model.users.UserVO;
public class UsersModifyProAction implements Action {
	UserDAO dao = UserDAO.getInstance();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//회원정보 가져오는 메소드 추가 요망
		
		
		request.setCharacterEncoding("utf-8");
		
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
