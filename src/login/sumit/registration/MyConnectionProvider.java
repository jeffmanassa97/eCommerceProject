 package login.sumit.registration;
 
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider {
	
	static Connection con = null;

	public static Connection getCon() {
		String username = "root";
		String pwd = "Vici1997!";
		// Creating database called eCommerceProj
		String connUrl = "jdbc:mysql://localhost:3306/eCommerceProj?useSSL=false";
		
		try {
 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(connUrl, username, pwd);
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("SQLException: " + e.getMessage());
		}
		return con;
	}
	
}
