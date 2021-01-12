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
			if (rs.next())
				money = rs.getInt("money");
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

	public Boolean idIsAble(String id) {
		String query = "SELECT ID FROM COIN_USER WHERE ID = ?";
		Boolean isAble = false;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				isAble = false;
			else
				isAble = true;
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
		return isAble;
	}
	
	public int signUp(UserVO vo) {
		String query = "insert into COIN_USER(ID,PW,EMAIL1,EMAIL2) values(?,?,?,?)";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail1());
			pstmt.setString(4, vo.getEmail2());
			row = pstmt.executeUpdate();
			insertCoinMoney(vo.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return row;
	}
	
	private void insertCoinMoney(String id) {
		String query = "insert into COIN_MONEY(ID) values (?)";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}

	public String emailCheck(String email1, String email2) {
		String query = "SELECT ID FROM COIN_USER WHERE EMAIL1 = ? AND EMAIL2 = ?";
		String id = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email1);
			pstmt.setString(2, email2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
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
		return id;
	}
}
