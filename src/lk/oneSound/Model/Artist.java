package lk.oneSound.Model;

public class Artist {
	
	private int artistId;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String username;
	private String password;
	
	public Artist(int artistId, String firstName, String lastName, String email, String companyName, String username,
			String password) {
		
		this.artistId = artistId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.companyName = companyName;
		this.username = username;
		this.password = password;
	}

	public int getArtistId() {
		return artistId;
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

	public String getCompanyName() {
		return companyName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	
	
	
}
