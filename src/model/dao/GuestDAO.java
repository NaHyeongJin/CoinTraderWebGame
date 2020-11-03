package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.vo.GuestVO;
import util.DBManager;

public class GuestDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 전체 게시물 수 카운트
	public int guestCount() {
		String query = "select count(*) as counter from tbl_guest";
		int count = 0; // 리턴 용
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("counter");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 전체 목록 리스트
	public List<GuestVO> guestList(){
		String query = "select * from tbl_guest order by idx desc";
		List<GuestVO> list =new ArrayList<GuestVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GuestVO guest = new GuestVO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setContents(rs.getString("contents"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				
				list.add(guest);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	// 등록 메소드
	public int guestWrite(GuestVO vo) {
		String query = "insert into tbl_guest(idx, name, subject, contents) values(tbl_guest_seq_idx.nextval,?,?,?)";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			
			row=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 특정게시물 조회수 증가 메소드
	public void guestHits(int idx) {
		String query = "update tbl_guest set readcnt=readcnt+1 where idx=?";
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	// 특정 게시물 검색 메소드
	public GuestVO guestSelect(int idx) {
		String query = "select * from tbl_guest where idx=?";
		GuestVO vo = new GuestVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	// 수정 처리 메소드
	public int guestModify(GuestVO vo) {
		String query = "update tbl_guest set subject=?, contents=? where idx=?";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
			row=pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 삭제 처리 메소드
	public int guestDelete(int idx) {
		String query = "delete from tbl_guest where idx=?";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			row=pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
}
