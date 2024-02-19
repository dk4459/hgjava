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
			
		}catch(Exception e) {
		    e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}
	//회원가입 중복값 확인 
	public int check(User user) {
		conn = DAO1.getConn();
		sql = "SELECT user_id,user_pw,user_phone,user_name,user_nic\r\n"
				+ "FROM users "
				+ "WHERE user_id = ? "
				+ "OR user_phone = ? "
				+ "OR user_nic = ? ";
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, user.getUserId());
					psmt.setString(2, user.getUserPhone());
					psmt.setString(3,user.getUserNic());
					rs = psmt.executeQuery();
					if(rs.next()) {
						if(rs.getString("user_id").equals(user.getUserId())) {
							return 0;
						}else if(rs.getString("user_phone").equals(user.getUserPhone())) {
							return 1;
						}else if (rs.getString("user_nic").equals(user.getUserNic())) {
							return 2;
						}
						
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return -1;
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
		sql ="INSERT INTO removes(user_id) "
				+ "   (SELECT (user_id) "
				+ "    FROM users "
				+ "    WHERE user_id = ? "
				+ "    AND user_pw = ?) ";
			
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			int r =psmt.executeUpdate();	
			
		
			
			if (r >0) {
						return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("입력한 값이 맞지 않습니다.");	
			
		}
		
		return false;
	}
	//회원탈퇴 조회
	public boolean removeSerch(String id) {
		conn = DAO1.getConn();
		sql = "SELEcT * "
				+ "FROM removes "
				+ "Where user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("user_id").equals(id)) {
					return true;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	//회원탈퇴 풀기
	public boolean removeCancel(String id, String pw) {
		conn = DAO1.getConn();
		sql =   " DELETE removes "
				+ "WHERE user_id = (Select user_id"
				+ "                 FROM users"
				+ "                 WHERE user_id =  ? "
				+ "                 AND   user_pw = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
