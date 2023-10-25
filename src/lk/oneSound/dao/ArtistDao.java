package lk.oneSound.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Interface.IArtist;
import lk.oneSound.Model.Artist;
import lk.oneSound.Model.Customer;
import lk.oneSound.Utility.DBConnection;

public class ArtistDao implements IArtist{
	
	public ArrayList<Artist> validate(String username, String password) {

		ArrayList<Artist> artist = new ArrayList<>();

		// validate
		try {

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM artist WHERE Username = '" + username + "' AND Password = '" + password + "'";
			ResultSet result = stmt.executeQuery(sql);

			if (result.next()) {

				int id = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);
				String email = result.getString(4);
				String companyName = result.getString(5);
				String usernameU = result.getString(6);
				String passwordU = result.getString(7);
				// String userRole = result.getString(7);

				Artist ar = new Artist(id, firstname, lastname, email,companyName, usernameU, passwordU);

				artist.add(ar);

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return artist;
	}

	//Insert Artist 
	public boolean insertArtist(String firstName, String lastName, String email, String companyName, String username,
			String password) {
		boolean isSuccess = false;

		try {

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO artist VALUES (0, '" + firstName + "', '" + lastName + "', '" + email + "','"+companyName+"', '"
					+ username + "', '" + password + "') ";
			int result = stmt.executeUpdate(sql);

			if (result > 0) {

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
	
	//Update Artist Details
	
	public boolean UpdateArtist(String id, String firstname, String lastname, String email,String companyname, String username) {
		boolean isSuccess = false;
		
		try {
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE artist SET FirstName = '"+firstname+"', LastName = '"+lastname+"', Email = '"+email+"',CompanyName ='"+companyname+"', Username = '"+username+"' WHERE ArtistId = '"+id+"' ";
			int result = stmt.executeUpdate(sql);

			if (result > 0) {

				isSuccess = true;
			}

			else {
				isSuccess = false;

			}
			
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
	}
	
	//Retrieve Artist Details
	public List<Artist> getArtistDetails(String id){
		
		int intId = Integer.parseInt(id);
		
		ArrayList<Artist> artist = new ArrayList<>();
		
		try {

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM artist WHERE ArtistId = '"+intId+"'";
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				
				int uid = result.getInt(1);
				String fname = result.getString(2);
				String lname = result.getString(3);
				String email = result.getString(4);
				String companyname = result.getString(5);
				String uname = result.getString(6);
				String pass = result.getString(7);
				
				Artist ar = new Artist(uid,fname,lname,email,companyname,uname,pass);
				
				artist.add(ar);
				
				
			}
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return artist;
		
		
		
	}
	//Delete Artist Account
	
	public boolean DeleteArtist(String id) {
		
		boolean isSuccess = false;
		
		int intId = Integer.parseInt(id);
		
		try {
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM artist WHERE ArtistId = '"+intId+"'";
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {

				isSuccess = true;
			}

			else {
				isSuccess = false;

			}
			
			
			
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	


}
