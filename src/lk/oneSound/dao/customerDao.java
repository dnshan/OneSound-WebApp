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
	
	@SuppressWarnings("unused")
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
				String lastname = result.getNString(3);
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

}
