package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DabsDAO {
	//필드
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
				}
			
		}
	//댓글 만들기
	public boolean insertDab(Dabs dabs ) {
		conn=DAO1.getConn();
		sql = "INSERT INTO dabs (user_id,"
				+ "                 board_no,"
				+ "                 dap)"
				+ "VALUES (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dabs.getUserId());
			psmt.setInt(2, dabs.getBoardNO());
			psmt.setString(3, dabs.getDap());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}return false;
	}
}
