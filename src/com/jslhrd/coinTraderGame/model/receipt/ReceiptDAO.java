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
	
	public List<ReceiptVO> getReceipt(String id) {
		String sql = "SELECT B.NAME, A.COUNT, A.REGDATE, A.PRICE FROM COIN_RECEIPT A, COIN_LIST B WHERE ID = ? AND A.NUM = B.NUM ORDER BY REGDATE";
		List<ReceiptVO> list = new ArrayList<ReceiptVO>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiptVO vo = new ReceiptVO();
				vo.setName(rs.getString("name"));
				vo.setCount(rs.getInt("count"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setPrice(rs.getInt("price"));
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
}
