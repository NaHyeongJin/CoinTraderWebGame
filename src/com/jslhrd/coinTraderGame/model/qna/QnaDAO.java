package com.jslhrd.coinTraderGame.model.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jslhrd.coinTraderGame.util.DBUtil;


public class QnaDAO {
	Logger log = Logger.getGlobal();
	private static QnaDAO instance = new QnaDAO();
	public static QnaDAO getInstance() {
		return instance;
	}
	//리스트 번호 출력
	
	// 전체 게시물 수 카운트
	public int QnaCount(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from coin_qna where id=?";
		int row =0; 
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// 게시물 리스트 (10개씩) 리턴 - 검색조건이 없음
	public List<QnaVO> QnaList(String id, int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVO> list = new ArrayList<QnaVO>();
		String query = "select rownum, X.subject, X.contents, X.answer, X.regdate from \r\n" + 
				"(select rownum as rnum, A.* from coin_qna A order by regdate desc) X\r\n" + 
				"where rnum < ? and rnum > ? and id = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setIdx(rs.getInt("rownum"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setAnswer(rs.getString("answer"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 게시물 리스트 (10개씩) 리턴 - admin
	public List<QnaVO> QnaList_admin(int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVO> list = new ArrayList<QnaVO>();
		String query = "select rownum, X.subject, X.contents, X.answer, X.regdate from \r\n" + 
				"(select rownum as rnum, A.* from coin_qna A order by regdate desc) X\r\n" + 
				"where rnum < ? and rnum > ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setIdx(rs.getInt("rownum"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setAnswer(rs.getString("answer"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//상세보기(view)
	public QnaVO QnaView(String id, int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select rownum, X.subject, X.contents, X.answer, X.regdate from \r\n" + 
				"(select rownum as rnum, A.* from coin_qna A order by regdate desc) X\r\n" + 
				"where id = ? and rownum = ?";
		QnaVO vo = new QnaVO();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("rownum"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setAnswer(rs.getString("answer"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	//글쓰기(write)
	public int QnaWrite(QnaVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into coin_qna(id,subject,contents) values(?,?,?)";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	//수정하기(modify)
	public int QnaModify(QnaVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update coin_qna set subject=?, contents=? where id=? and regdate=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getRegdate());
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	//삭제(delete)
	public int QnaDelete(String id, String regdate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from coin_qna where id=? and regdate=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, regdate);
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	//답변
	public int QnaAnswer(QnaVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE COIN_QNA SET ANSWER = ? WHERE REGDATE = "
				+ "(SELECT REGDATE FROM (SELECT REGDATE FROM COIN_QNA ORDER BY REGDATE DESC) WHERE ROWNUM = ?)";
		int row = 0;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAnswer());
			pstmt.setInt(2, vo.getIdx());
			row = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return row;
	}

}
