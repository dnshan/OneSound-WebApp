package lk.oneSound.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Interface.ICustomer;
import lk.oneSound.Model.customer;
import lk.oneSound.Utility.DBConnection;

public class customerDao implements ICustomer {
	
	public List<customer> validate(String username, String password){
		
		ArrayList<customer> user = new ArrayList<>();
		
		//validate
		try {
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE Username = '"+username+"' AND Password = '"+password+"'";
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
		
		return user;
	}

}
