package co.yedam.common;
import java.sql.Connection;
import java.sql.DriverManager;


// Connection:
public class DAO {

	public static Connection conn;
	
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.51:1521:xe","yedam","1234");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}