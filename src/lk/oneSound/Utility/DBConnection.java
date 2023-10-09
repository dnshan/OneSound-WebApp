package lk.oneSound.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/onlinemusicstore";
	private static String username = "root";
	private static String passwordDB = "";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, passwordDB);
			
			
			
		}
		
		catch(Exception e) {
			
			System.out.println("Database Connection is not Success");
		}
		
		return con;
		
		
	}
	

}
