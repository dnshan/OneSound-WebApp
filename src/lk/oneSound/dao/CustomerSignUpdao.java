package lk.oneSound.dao;

import java.sql.Connection;
import java.sql.Statement;

import lk.oneSound.Interface.ICustomer;
import lk.oneSound.Utility.DBConnection;



public class CustomerSignUpdao implements ICustomer {
	
	
public boolean insertCustomer(String firstname, String lastname, String email, String username, String password) {
		
		boolean isSuccess = false;
			
		try {
			
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO user VALUES (0, '"+firstname+"', '"+lastname+"', '"+email+"', '"+username+"', '"+password+"') ";
			int result = stmt.executeUpdate(sql);
			
			
			if(result > 0) {
				
				isSuccess = true;	
			}
			
			else {
				isSuccess = false;
				
			}
			
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
		
	}
	
	
	

}
