package lk.oneSound.Utility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMSSQL {
	
	public static Connection getConnection() {

		Connection conn = null;

		try {
			
//			Dinusha
			String dbURL = "jdbc:sqlserver://localhost;DatabaseName=onlinemusicstore;encrypt=true;trustServerCertificate=true;";
			String userName = "sa";
			String password = "dinusha";
			
//			//Dasuni
//			String dbURL = "jdbc:sqlserver://DESKTOP-8G691HC\\SQLEXPRESS;DatabaseName=OnlineWatchingMoviesandTVSeries;encrypt=true;trustServerCertificate=true;";
//			String userName = "sa";
//			String password = "*272617Ps*";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(dbURL, userName, password);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				return conn;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
