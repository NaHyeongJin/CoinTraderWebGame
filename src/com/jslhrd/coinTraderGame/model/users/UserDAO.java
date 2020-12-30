package com.jslhrd.coinTraderGame.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public int UserModify(UserVO vo) {
		String query = "update COIN_USER set pw=? where id=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, vo.getMoney());
			pstmt.setString(4, vo.getEmail1());
			pstmt.setString(5, vo.getEmail2());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보 수정중 오류");
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (Exception e) {

			}
		}
		return row;
	}

	public String getTitle(String id) {
		String sql = "select COIN_USER from email where id=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

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
		return id;
	}

	// 로그인 메소드(세션 유지)
	public UserVO login(String id, String pw) {
		String query = "select id,pw from COIN_USER where id=?";
		UserVO lvo = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			boolean b = rs.next();
			if (b) {
				lvo = new UserVO();
				lvo.setId(rs.getString("id"));
				lvo.setPw(rs.getString("pw"));

				if (lvo.getPw().equals(pw)) {
					lvo.setRow(1);
				} else {
					lvo.setRow(0);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		try {

			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lvo;

	}
	// 충전 메소드

}
