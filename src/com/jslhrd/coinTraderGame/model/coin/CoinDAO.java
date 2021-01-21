package com.jslhrd.coinTraderGame.model.coin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jslhrd.coinTraderGame.util.DBUtil;

public class CoinDAO {
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;

	private static CoinDAO instance;

	private CoinDAO() {
	}

	static public CoinDAO getInstance() {
		if (instance == null)
			instance = new CoinDAO();
		return instance;
	}

	public String coinUpdateDate() {
		String date = "";
		String sql = "SELECT TIME FROM (SELECT TIME FROM COIN_PRICE ORDER BY TIME) WHERE ROWNUM = 1";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			date = (rs.next()) ? rs.getString("TIME") : date;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
		return date;
	}

	public int[][] coinPrices() {
		int[][] prices = new int[4][70];
		String sql = "SELECT * FROM COIN_PRICE ORDER BY TIME";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				prices[rs.getInt("NUM") - 1][cnt / 4] = rs.getInt("PRICE");
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}

		return prices;
	}

	public void addPrices(int[][] prices) {
		deletePrices();
		for (int i = 0; i < prices[0].length; i++) {
			String sql = "INSERT ALL\r\n" + "INTO COIN_PRICE(NUM, TIME, PRICE) VALUES(1, SYSDATE + ?/86400, ?)\r\n"
					+ "INTO COIN_PRICE(NUM, TIME, PRICE) VALUES(2, SYSDATE + ?/86400, ?)\r\n"
					+ "INTO COIN_PRICE(NUM, TIME, PRICE) VALUES(3, SYSDATE + ?/86400, ?)\r\n"
					+ "INTO COIN_PRICE(NUM, TIME, PRICE) VALUES(4, SYSDATE + ?/86400, ?)\r\n" + "SELECT * FROM DUAL";
			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				for (int j = 0; j < prices.length; j++) {
					pstmt.setInt(j * 2 + 1, i);
					pstmt.setInt(j * 2 + 2, prices[j][i]);
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
	}

	private void deletePrices() {
		String sql = "DELETE COIN_PRICE";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public void coinBuy(String id, int cnt, int amount, int price) {
		moneyUpdate(id, amount * price * -1);
		String sql = "INSERT ALL\r\n"
				+ "INTO COIN_RECEIPT(NUM, COUNT, PRICE, ID) VALUES(?, ?, ?, ?)\r\n"
				+ "INTO COIN_MONEY(ID, MONEY) VALUES(?, (SELECT MONEY FROM COIN_USER WHERE ID = ?))\r\n"
				+ "SELECT * FROM DUAL";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, price);
			for (int i = 4; i < 7; i++) {
				pstmt.setString(i, id);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	// id의 돈을 money만큼 증감
	private void moneyUpdate(String id, int money) {
		String sql = "UPDATE COIN_USER SET MONEY = (MONEY + ?) WHERE ID = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	public void coinSell(String id, int cnt, int amount, int price) {
		moneyUpdate(id, amount * price);
		String sql = "INSERT ALL\r\n"
				+ "INTO COIN_RECEIPT(NUM, COUNT, PRICE, ID) VALUES(?, ?, ?, ?)\r\n"
				+ "INTO COIN_MONEY(ID, MONEY) VALUES(?, (SELECT MONEY FROM COIN_USER WHERE ID = ?))\r\n"
				+ "SELECT * FROM DUAL";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, amount * -1);
			pstmt.setInt(3, price);
			for (int i = 4; i < 7; i++) {
				pstmt.setString(i, id);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

}
