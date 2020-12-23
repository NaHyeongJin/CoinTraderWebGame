package com.jslhrd.coinTraderGame.service.users;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.coinTraderGame.model.users.UserDAO;
import com.jslhrd.coinTraderGame.model.users.UserVO;
import com.jslhrd.coinTraderGame.service.Action;

public class UsersModifyProAction implements Action {
	UserDAO dao = UserDAO.getInstance();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		UserVO vo = new UserVO();
		vo.setPw(request.getParameter("pw1"));
		vo.setId(request.getParameter("user_id"));
		UserDAO dao = UserDAO.getInstance();
		int row = dao.UserModify(vo);
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("users/user_edit_pro.jsp");
		rd.forward(request, response);
		
	}
}
