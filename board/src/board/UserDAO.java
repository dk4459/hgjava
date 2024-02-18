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
	PreparedStatement psmt1;
	PreparedStatement psmt2;
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
		}
		return false;
	}
     //로그인
	public int  login(String id, String pw) {
		conn = DAO1.getConn();
		sql =     "SELECT user_id, "
				+ "        user_pw "
				+ "FROM users "
				+ "WHERE user_id = ? "
				+ "AND user_pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("user_id").equals(id) && rs.getString("user_pw").equals(pw)) {
					return 0; // 로그인 성공
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; 
	}
	
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
//	//회원정보 조회
	public List<User> userInf(String id, String pw) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		List<User> list = new ArrayList<>();
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
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserName(rs.getString("user_name"));
				user.setUserDate(rs.getDate("user_Date"));
				user.setUserNic(rs.getString("user_Nic"));
				list.add(user);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return null;
	}
	//회원정보 수정
	public boolean pwModify(User user) {
		conn = DAO1.getConn();
		sql = "UPDATE users\r\n" + 
				"SET user_pw = ?\r\n" + 
				"WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserId());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}return false;
		
	}
	public boolean phoneModify(User user) {
		conn = DAO1.getConn();
		sql = "UPDATE users  " + 
				"SET user_phone = ?  " + 
				"WHERE user_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPhone());
			psmt.setString(2, user.getUserId());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}return false;
		
	}
	public boolean nameModify(User user) {
		conn = DAO1.getConn();
		sql = "UPDATE users " + 
				"SET user_name = ? " + 
				"WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getUserId());
			int r = psmt.executeUpdate();
		    if(r>0) {
		    	return true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			
		}return false;
		
	}
	public boolean nicModify(User user) {
		conn  =DAO1.getConn();
		sql = "UPDATE users " + 
				"SET user_nic = ? " + 
				"WHERE user_id = ?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserNic());
			psmt.setString(2, user.getUserId());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			} 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}return false;
		
	}
	
	//회원탈퇴
	public boolean removeUser(String id , String pw) {
		conn = DAO1.getConn();
		sql ="DELETE dabs\r\n"
				+ "WHERE user_id = (SELECT user_id\r\n"
				+ "                 FROM users\r\n"
				+ "                 WHERE user_id = ?\r\n"
				+ "                 AND user_pw = ?);";
		String sql1 = "DELETE boards\r\n"
				+ "WHERE user_id = (SELECT user_id\r\n"
				+ "                 FROM users\r\n"
				+ "                 WHERE user_id = '?'\r\n"
				+ "                 AND user_pw = '?')";
		String sql2=  "DELETE users "
				+ "				+ \"WHERE user_id = (SELECT user_id "
				+ "	            FROM users "
				+ "				WHERE user_id = '?' "
				+ "	             AND user_pw = '?')";		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.executeUpdate();	
			psmt1 = conn.prepareStatement(sql1);
			psmt1.setString(1, id);
			psmt1.setString(2, pw);
			psmt1.executeUpdate();
			psmt2 = conn.prepareStatement(sql2);
			psmt2.setString(1, id);
			psmt2.setString(2, pw);
			int r = psmt2.executeUpdate();
			if (r >0) {
				return true;
			}
		}catch (SQLException e) {
			System.out.println("입력한 값이 맞지 않습니다.");	
		}
		
		return false;
	}
}
