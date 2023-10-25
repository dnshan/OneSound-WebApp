package lk.oneSound.Interface;

import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Model.Artist;

public interface IArtist {
	
	ArrayList<Artist> validate(String username, String password);
	boolean insertArtist(String firstName, String lastName, String email, String companyName, String username,String password);
	public boolean UpdateArtist(String id, String firstname, String lastname, String email,String companyname, String username);
	public List<Artist> getArtistDetails(String id);
}
