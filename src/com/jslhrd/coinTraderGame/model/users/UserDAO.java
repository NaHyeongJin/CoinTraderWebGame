package com.jslhrd.coinTraderGame.model.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				vo.setPw(rs.getString("pw"));
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

	public List<UserGraphVO> getMoneyList(String id) {
		List<UserGraphVO> list = new ArrayList<UserGraphVO>();
		String query = "SELECT MONEY,regdate FROM COIN_MONEY WHERE ID = ? ORDER BY REGDATE";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer money = rs.getInt("money");
				String regdate = rs.getString("regdate");
				UserGraphVO vo = new UserGraphVO();
				vo.setMoney(money);
				vo.setRegdate(regdate);
				list.add(vo);
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

	public Boolean idIsAble(String id) {
		String query = "SELECT ID FROM COIN_USER WHERE ID = ?";
		Boolean isAble = true;
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
		if (!isEmailAble(vo.getEmail1(), vo.getEmail2())) {
			return 0;
		}
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
			insertCoinMoney(vo.getId(), 50000);
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

	private void insertCoinMoney(String id, int money) {
		String query = "insert into COIN_MONEY(ID, MONEY) values (?, ?)";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, money);
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

	public Boolean loginCheck(String id) {
		String query = "SELECT EMAILCHECK FROM COIN_USER WHERE ID = ?";
		Boolean answer = false;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				answer = (rs.getString("EMAILCHECK").equals("1")) ? true : false;
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
		return answer;
	}

	public void authSuccess(String id) {
		String query = "UPDATE COIN_USER SET EMAILCHECK = '1' WHERE ID = ?";
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

	public void setPwCheck(String id, int i) {
		String query = "UPDATE COIN_USER SET PWCHECK = ? WHERE ID = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i);
			pstmt.setString(2, id);
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

	public Boolean pwCheck(String id) {
		String query = "SELECT PWCHECK FROM COIN_USER WHERE ID = ?";
		Boolean answer = false;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				answer = (rs.getString("PWCHECK").equals("1")) ? true : false;
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
		return answer;
	}

	public Boolean isEmailAble(String email1, String email2) {
		String query = "SELECT ID FROM COIN_USER WHERE EMAIL1 = ? AND EMAIL2 = ?";
		Boolean isAble = true;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email1);
			pstmt.setString(2, email2);
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

	public int Withdrawal(String id, String pw) {
		String query = "DELETE FROM COIN_USER WHERE ID = ? AND PW = ?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
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

	public int ChargeMoney(int money, String id) {
		int row = 0;
		String query = "update coin_user set money = money + ? where id = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			row = pstmt.executeUpdate();
			insertCoinMoney(id, getUserMoney(id));
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
}
