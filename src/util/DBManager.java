package util;
import java.sql.*;

public class DBManager {
	public static Connection getConnection() {
		Connection myConn=null;
		String myDriver ="oracle.jdbc.driver.OracleDriver";
		String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd45";
		String myPass = "1234";
		
		try {
			Class.forName(myDriver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			myConn=DriverManager.getConnection(myURL, myID, myPass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return myConn;
	}
	//select 수행 후 리소스 해제
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// insert,update,delete 수행 후 리소스 해제
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
