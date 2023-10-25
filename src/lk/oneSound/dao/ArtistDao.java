package lk.oneSound.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import lk.oneSound.Interface.IArtist;
import lk.oneSound.Model.Artist;
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
	
	

}
