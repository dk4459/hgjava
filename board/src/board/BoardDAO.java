package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	Connection conn; 
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	void disconn() {
		try {
		  if(conn != null) {	
		   conn.close();
		} if(psmt != null) {
			 psmt.close();
		} if(rs != null) {
			rs.close();
		}
	   }
		catch (SQLException e) {
				e.printStackTrace();
			}finally {
			  disconn();
			}
		
	}

}
