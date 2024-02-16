package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

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
		}catch(SQLIntegrityConstraintViolationException c) {
			System.out.println("정확한 게시글 번호를 입력하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}return false;
	}
	//댓글 목록보기
	public List<Dabs> getList(int no){
		conn=DAO1.getConn();
		List<Dabs> list = new ArrayList<>();
		sql = "SELECT nvl(user_id,' 익명') user_id," + 
				"       board_no, " + 
				"        dap " + 
				"        FROM dabs  " + 
				"        WHERE Board_no = ?";
		try {
		
		
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while(rs.next()) {
			Dabs dabs = new Dabs();
			dabs.setUserId(rs.getString("user_id"));
			dabs.setBoardNO(rs.getInt("board_no"));
			dabs.setDap(rs.getString("dap"));
			list.add(dabs);
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("정확한 게시글 번호를 적어주세요");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disconn();
		}return list;

	}
}
