package lk.oneSound.Model;

public class Customer {

	private int uid;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;

	public Customer(int uid, String firstName, String lastName, String email, String username, String password) {

		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getuid() {
		return uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
