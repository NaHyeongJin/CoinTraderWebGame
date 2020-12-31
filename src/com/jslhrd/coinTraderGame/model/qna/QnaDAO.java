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
	public int QnaCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from coin_qna";
		int row =0; 
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
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
	// 전체 게시물 수 카운트   
	public int QnaCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from coin_qna where " + s_query;
		int row =0; 
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
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
				
			}
		}
		return row;
	}
	// 게시물 리스트 (10개씩) 리턴 - 검색조건이 없음
	public List<QnaVO> QnaList(int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVO> list = new ArrayList<QnaVO>();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from coin_qna order by regdate asc) A "
				+ "where rownum <= ? order by rnum desc) X where X.rnum >=?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setRnum(rs.getInt("rnum"));
				vo.setId(rs.getString("id"));
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
	// 게시물 리스트 (10개씩) 리턴 - 검색조건이 있음
	public List<QnaVO> QnaList(String s_query, int startpage, int endpage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVO> list = new ArrayList<QnaVO>();
		String query = "select X.* from (select rownum as rnum, A.* from ("
				+ "select * from coin_qna order by regdate desc) A "
				+ "where "+ s_query + " and rownum <= ?) X where "+ s_query + " and X.rnum >=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO vo = new QnaVO();
				vo.setId(rs.getString("id"));
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
	public QnaVO QnaView(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from coin_qna where id=?";
		QnaVO vo = new QnaVO();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
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
		
		String sql = "update coin_qna set subject=?, contents=? where id=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getId());
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
	public int QnaDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from coin_qna where id=?";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
		ResultSet rs = null;
//		String sql = "SELECT ID FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM COIN_QNA ORDER BY REGDATE) A) where rnum=?";
		String sql = "update into coin_qna set answer=? where id=?";
		int row = 0;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAnswer());
			pstmt.setString(2, vo.getId());
			row = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return row;
	}

}
