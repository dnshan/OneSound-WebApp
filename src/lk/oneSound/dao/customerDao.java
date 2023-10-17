package lk.oneSound.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Interface.ICustomer;
import lk.oneSound.Model.customer;
import lk.oneSound.Utility.DBConnection;
import lk.oneSound.Utility.DBConnectionMSSQL;

public class customerDao implements ICustomer {
	
<<<<<<< HEAD
	@SuppressWarnings("unused")
=======
	@Override
	
>>>>>>> a1ad5432ca815fa30a1e3533f51c7ca854febbc6
	public List<customer> validate(String username, String password){
		
		ArrayList<customer> user = new ArrayList<>();
		
		//validate
		try {
			
			Connection con = DBConnectionMSSQL.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM users WHERE Username = '"+username+"' AND Password = '"+password+"'";
			ResultSet result = stmt.executeQuery(sql);
			
			if(result.next()) {
				
				int id = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);
				String email = result.getString(4);
				String usernameU = result.getString(5);
				String passwordU = result.getString(6);
				//String userRole = result.getString(7);
				
				customer u = new customer(id, firstname, lastname, email, usernameU, passwordU);
				
				user.add(u);
				
				
			}
			
		}
		
		catch(Exception e){
			
			e.printStackTrace();
				
		}
		
		if (user != null) {
			return user;
		} else {
			return null;
		}
		
	}
	
	public boolean insertCustomer(String firstname, String lastname, String email, String username, String password) {
		return false;
	}
	
	//Insert Customer

	public  boolean insertCustomer(String firstname, String lastname, String email, String username, String password) {
		
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
