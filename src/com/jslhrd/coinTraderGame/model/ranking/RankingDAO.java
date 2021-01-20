package com.jslhrd.coinTraderGame.model.ranking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.coinTraderGame.util.DBUtil;

public class RankingDAO {
	private static RankingDAO instance = new RankingDAO();

	public static RankingDAO getInstance() {
		return instance;
	}

	// 랭킹
	public List<RankingVO> Ranking() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RankingVO> list = new ArrayList<RankingVO>();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select id, money from coin_user order by money desc)A)X";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RankingVO vo = new RankingVO();
				vo.setRank(rs.getInt("rnum"));
				vo.setId(rs.getString("id"));
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
