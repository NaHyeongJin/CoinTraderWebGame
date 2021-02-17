package com.jslhrd.coinTraderGame.model.receipt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.coinTraderGame.util.DBUtil;

public class ReceiptDAO {
	private static ReceiptDAO instance = new ReceiptDAO();

	public static ReceiptDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int ReceiptCount(String id) {
		String query = "select count(*) from coin_receipt where id=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	//검색 후 게시물 갯수
	public int ReceiptCount(String id, String startday, String endday) {
		String query = "select count(*) from coin_receipt where id=? and regdate >= TO_DATE(?,'YYYY-MM-DD') and regdate < TO_DATE(?,'YYYY-MM-DD')+1";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, startday);
			pstmt.setString(3, endday);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// 게시물 리스트 (20개씩) 리턴 - 검색조건이 없음
	public List<ReceiptVO> ReceiptList(String id, int startpage, int endpage) {
		List<ReceiptVO> list = new ArrayList<ReceiptVO>();
		String query = "SELECT F.* FROM (SELECT X.*, ROWNUM RNUM FROM \r\n" + 
				"(SELECT B.NAME, A.COUNT, A.REGDATE, A.PRICE, C.MONEY FROM COIN_RECEIPT A, COIN_LIST B, COIN_MONEY C \r\n" + 
				"WHERE A.ID = ? AND A.NUM = B.NUM AND A.REGDATE = C.REGDATE ORDER BY REGDATE DESC) X) F \r\n" + 
				"WHERE RNUM < ? AND RNUM > ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, endpage);
			pstmt.setInt(3, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiptVO vo = new ReceiptVO();
				vo.setName(rs.getString("name"));
				vo.setCount(rs.getInt("count"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setPrice(rs.getInt("price"));
				vo.setMoney(rs.getInt("money"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 게시물 리스트 (20개씩) 리턴 - 검색조건이 있음
	public List<ReceiptVO> ReceiptList(String id, int startpage, int endpage, String startday, String endday) {
		List<ReceiptVO> list = new ArrayList<ReceiptVO>();
		String query = "SELECT F.* FROM (SELECT X.*, ROWNUM RNUM FROM(SELECT B.NAME, A.COUNT, A.REGDATE, A.PRICE, C.MONEY \r\n" + 
				"FROM COIN_RECEIPT A, COIN_LIST B, COIN_MONEY C WHERE A.ID = ? AND A.NUM = B.NUM \r\n" + 
				"AND A.REGDATE = C.REGDATE AND A.REGDATE >= TO_DATE(?,'YYYY-MM-DD') \r\n" + 
				"AND A.REGDATE <  TO_DATE(?,'YYYY-MM-DD')+1 ORDER BY REGDATE DESC) X) F \r\n" + 
				"WHERE RNUM < ? AND RNUM > ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, startday);
			pstmt.setString(3, endday);
			pstmt.setInt(4, endpage);
			pstmt.setInt(5, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiptVO vo = new ReceiptVO();
				vo.setName(rs.getString("name"));
				vo.setCount(rs.getInt("count"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setPrice(rs.getInt("price"));
				vo.setMoney(rs.getInt("money"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
