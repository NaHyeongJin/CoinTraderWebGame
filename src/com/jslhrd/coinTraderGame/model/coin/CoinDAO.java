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
	private CoinDAO() {}
	static public CoinDAO getInstance() {
		if (instance == null) 
			instance = new CoinDAO();
		return instance;
	}
	
	public String coinUpdateDate() {
		String date = "";
		String sql = "SELECT TIME FROM (SELECT TIME FROM ACOIN ORDER BY TIME) WHERE ROWNUM <= 1";
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
			} catch (Exception e2) {}
		}
		return date;
	}
	
	public int[][] coinPrices() {
		int[][] prices = new int[4][70];
		String sql = "SELECT A.PRICE A_PRICE, B.PRICE B_PRICE, C.PRICE C_PRICE, D.PRICE D_PRICE\r\n"
				+ "FROM ACOIN A, BCOIN B, CCOIN C, DCOIN D\r\n"
				+ "WHERE A.TIME = B.TIME AND B.TIME = C.TIME AND C.TIME = D.TIME\r\n"
				+ "ORDER BY A.TIME, B.TIME, C.TIME, D.TIME";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				prices[0][cnt] = rs.getInt("A_PRICE");
				prices[1][cnt] = rs.getInt("B_PRICE");
				prices[2][cnt] = rs.getInt("C_PRICE");
				prices[3][cnt] = rs.getInt("D_PRICE");
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (Exception e2) {}
		}
		
		return prices;
	}
	
	public void addPrices(int[][] prices) {
		deletePrices();
		for(int i = 0; i < prices[0].length; i++) {
			String sql = "INSERT ALL\r\n"
					+ "INTO ACOIN (TIME, PRICE)\r\n"
					+ "VALUES (SYSDATE + ?/86400, ?)\r\n"
					+ "INTO BCOIN (TIME, PRICE)\r\n"
					+ "VALUES (SYSDATE + ?/86400, ?)\r\n"
					+ "INTO CCOIN (TIME, PRICE)\r\n"
					+ "VALUES (SYSDATE + ?/86400, ?)\r\n"
					+ "INTO DCOIN (TIME, PRICE)\r\n"
					+ "VALUES (SYSDATE + ?/86400, ?)\r\n"
					+ "SELECT * FROM DUAL";
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
		String[] sql = new String[4];
		sql[0] = "DELETE ACOIN";
		sql[1] = "DELETE BCOIN";
		sql[2] = "DELETE CCOIN";
		sql[3] = "DELETE DCOIN";
		try {
			conn = DBUtil.getConnection();
			for (int i = 0; i < sql.length; i++) {
				pstmt = conn.prepareStatement(sql[i]);
				pstmt.executeUpdate();
			}
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
