package lk.oneSound.Interface;

import java.util.ArrayList;

import lk.oneSound.Model.Artist;

public interface IArtist {
	
	ArrayList<Artist> validate(String username, String password);
	boolean insertArtist(String firstName, String lastName, String email, String companyName, String username,String password);
	
}
