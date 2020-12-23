package com.jslhrd.coinTraderGame.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jslhrd.coinTraderGame.util.DBUtil;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	

	//개인정보 수정
	public int UserModify(UserVO vo) {
		String query=" update COIN_USER set pw=? where id=?";
		int row=0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, vo.getMoney());
			pstmt.setString(4, vo.getEmail1());
			pstmt.setString(5, vo.getEmail2());
			
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("정보 수정중 오류");
		}finally {
			try {
				pstmt.close();
				conn.close();
				
			}catch (Exception e) {
				
			}
		}
		return row;
	}
	// 현금 충전 메소드
	public int 
	
}
