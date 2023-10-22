package lk.oneSound.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Interface.ICustomer;
import lk.oneSound.Model.Customer;
import lk.oneSound.Utility.DBConnection;

public class customerDao implements ICustomer {

	@Override

	public ArrayList<Customer> validate(String username, String password) {

		ArrayList<Customer> user = new ArrayList<>();

		// validate
		try {

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE Username = '" + username + "' AND Password = '" + password + "'";
			ResultSet result = stmt.executeQuery(sql);

			if (result.next()) {

				int id = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);
				String email = result.getString(4);
				String usernameU = result.getString(5);
				String passwordU = result.getString(6);
				// String userRole = result.getString(7);

				Customer u = new Customer(id, firstname, lastname, email, usernameU, passwordU);

				user.add(u);

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return user;
	}

	// Insert Customer

	public boolean insertCustomer(String firstname, String lastname, String email, String username, String password) {

		boolean isSuccess = false;

		try {

			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO user VALUES (0, '" + firstname + "', '" + lastname + "', '" + email + "', '"
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
