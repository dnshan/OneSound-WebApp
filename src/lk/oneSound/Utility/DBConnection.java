package lk.oneSound.Utility;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnection {
	
	//Dasuni
//	private static String url = "jdbc:mysql://localhost:3306/onlinemusicstore";
//	private static String username = "root";
//	private static String passwordDB = "Dxsuni2003@#";
//	private static Connection con;
//	
	
	//Dinusha
	private static String url = "jdbc:mysql://localhost:3306/onlinemusicstore";
	private static String username = "root";
	private static String passwordDB = "dinusha";
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