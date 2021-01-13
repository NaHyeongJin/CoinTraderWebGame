package com.jslhrd.coinTraderGame.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.jslhrd.coinTraderGame.util.DBUtil;

public class UserDAO {
	private UserDAO() {
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 개인정보 수정
	public int userModify(String id, String pw) {
		String query = "update COIN_USER set pw=? where id=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return row;
	}

	public UserVO getUser(String id) {
		String query = "SELECT * FROM COIN_USER WHERE ID = ?";
		UserVO vo = new UserVO();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setMoney(rs.getInt("money"));
				vo.setEmail1(rs.getString("email1"));
				vo.setEmail2(rs.getString("email2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return vo;
	}

	public int userLogin(String id, String pw) {
		String query = "SELECT PW FROM COIN_USER WHERE ID = ?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			row = (rs.next() && rs.getString("pw").equals(pw)) ? 1 : 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return row;
	}

	public int getUserMoney(String id) {
		String query = "SELECT MONEY FROM COIN_USER WHERE ID = ?";
		int money = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) money = rs.getInt("money");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return money;
	}
	
	public List getMoneyList(String id) {
		List list = new ArrayList();
		String query = "SELECT MONEY,regdate FROM COIN_MONEY WHERE ID = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Integer money = rs.getInt("money");
				String regdate = rs.getString("regdate").substring(0,10);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date=sdf.parse(regdate);
				long timestamp=date.getTime();
				long[] test = new long[]{timestamp,money};
				list.add(test);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	

}
