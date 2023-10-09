package lk.oneSound.Model;

public class customer {
	
	private int Uid;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Username;
	private String Password;
	
	public customer(int uid, String firstName, String lastName, String email, String username, String password) {
		
		Uid = uid;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Username = username;
		Password = password;
	}

	public int getUid() {
		return Uid;
	}

	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}

	public String getEmail() {
		return Email;
	}


	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	

}
