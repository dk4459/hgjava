package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


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
			}
		
	}
	//게시글 목록
	public List<Board> getList(String cate, int page){
		conn = DAO1.getConn();
		List<Board> list = new ArrayList<>();
		sql = "select b.board_no  , "
				+ "       b.board_title , "
				+ "       b.board_con , "
				+ "       u.user_id, "
				+ "       u.user_nic , "
				+ "       b.board_date , "
				+ "       b.cate "
				+ "from \r\n"
				+ "     (Select rownum rn, a.* "
				+ "      FROM "
				+ "          (Select * "
				+ "           FROM boards "
				+ "           WHERE cate = NVL(?,'유머') "
				+ "           ORDER BY board_no DESC) a) b join users u "
				+ "                                    ON (b.user_id = u.user_id) "
				+ "WHERE b.rn >  ( ? - 1 ) *5 "
				+ "And   b.rn <= ? * 5 ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			rs = psmt.executeQuery();
			while(rs.next()) {
			Board board  = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardCon(rs.getString("board_con"));
			board.setUserId(rs.getString("user_id"));
			board.setUserNic(rs.getString("user_nic"));
			board.setBoardDate(rs.getDate("board_date"));
			board.setCate(rs.getString("cate"));
			list.add(board);
			
			}
		}catch(SQLException e) {
			
		}finally {
			disconn();
		}
		return list;
	}
	//페이지
    public int getTotalCnt(String cate) {
    	conn = DAO1.getConn();
    	sql = "select count(*) as cnt "
    			+ " from boards " 
    			+" where cate = nvl(?,'유머') ";
    	try {
    		psmt = conn.prepareStatement(sql);
    		psmt.setString(1, cate);
    		rs = psmt.executeQuery();
    		if(rs.next()) {
    			return rs.getInt(1); //첫번째 칼럼에 있는 값을 반한하겠다.
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
			  disconn();
		}
    	return -1;
    }
   //들어가서 내용보기
    public List<Board> intoList(int no){
    	conn = DAO1.getConn();
		List<Board> list = new ArrayList<>();

		sql = "SELECT b.board_no, "
				+ "        b.board_title, "
				+ "        b.board_con, "
				+ "        b.user_id, "
				+ "        u.user_nic, "
				+ "        b.board_date, "
				+ "        b.cate "
				+ "FROM boards b JOIN users u "
				+ "              ON(b.user_id = u.user_id) "        
				+ " WHERE b.board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while(rs.next()) {
			Board board  = new Board();
			Dabs dabs = new Dabs();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardCon(rs.getString("board_con"));
			board.setUserId(rs.getString("user_id"));
			board.setUserNic(rs.getString("user_nic"));
			board.setBoardDate(rs.getDate("board_date"));
			dabs.setUserId(rs.getString("user_id"));
			board.setCate(rs.getString("cate"));
			list.add(board);
			
			}
		}
		catch(Exception e) {
			System.out.println("정확한 게시글번호를 적어주세요");
			

		}finally {
			disconn();
		}
		return list;
    }
    //게시글 작성
    
}
