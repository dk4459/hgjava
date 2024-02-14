package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
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
	//회원가입
	public boolean userAdd(User user) {
		conn = DAO1.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sql = "INSERT INTO users(user_num,"
				+ "                   user_id,"
				+ "                   user_pw,"
				+ "                   user_phone,"
				+ "                   user_name,"
				+ "                   user_nic)"
				+ "VALUES          (user_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			psmt.setString(3, user.getUserPhone());
			psmt.setString(4, user.getUserName());
			psmt.setString(5, user.getUserNic());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}return false;
	}
     //로그인
//	public int  login(String id, String pw) {
//		conn = DAO1.getConn();
//		sql =     "SELECT user_id, "
//				+ "        user_pw "
//				+ "FROM users "
//				+ "WHERE user_id = ? "
//				+ "AND user_pw = ?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, pw);
//			
//			rs = psmt.executeQuery();
//			
//			if (rs.next()) {
//				if (rs.getString("user_id").equals(id) && rs.getString("user_pw").equals(pw)) {
//					return 0; // 로그인 성공
//				}
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1; 
//	}
	//아이디 비밀번호 찾기
	
	public boolean serchInf(String name, String phone) {
		conn = DAO1.getConn();
		sql =     "SELECT user_id, "
				+ "        user_pw "
				+ "FROM users "
				+ "WHERE user_name = ? "
				+ "AND user_phone = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, phone);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println("id = "+rs.getString("user_id")); 
			    System.out.println("pw = "+rs.getString("user_pw"));
			    return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	}
	//회원정보 조회
	public boolean userInf(String id, String pw) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		conn = DAO1.getConn();
		sql =     "SELECT user_id, user_pw, user_phone, "
				+ " user_name, user_date, user_nic "
				+ "from users "
				+ "where user_id = ? "
				+ "And user_pw = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.printf("%5s %8s %13s %15s %15s %15s\n","이름","아이디","비밀번호","휴대전화","가입일자","닉네임");
				System.out.printf("%6s %9s %15s %15s %23s %15s",rs.getString("user_name"),rs.getString("user_id")
                ,rs.getString("user_pw"),rs.getString("user_phone")
                ,rs.getDate("user_date"),rs.getString("user_nic"));
			    return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	}
}
