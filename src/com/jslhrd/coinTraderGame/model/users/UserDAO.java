package com.jslhrd.coinTraderGame.model.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO intance = new UserDAO();
	public static UserDAO getInstance() {
		return getInstance();
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
		return conn;
	}
	
	//개인정보 수정
	public int UserModify(UserVO vo) {
		String query=" update User set id=? where pw=?";
		int row=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPw());
			
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
			return row;
		}
	}
	
}
