package board;
import java.sql.Connection;
import java.sql.DriverManager;


// Connection:
public class DAO1 {

	public static Connection conn;
	
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.111.1:1521:xe","board","1234");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}