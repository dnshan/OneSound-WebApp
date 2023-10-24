package lk.oneSound.dao;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Model.Review;
import lk.oneSound.Utility.DBConnection;

public class ReviewDao {
	
		
	
public  boolean addSong( int AId, String songName, String category, String duration) {
		
		boolean isSuccess = false;
			
		try {
			
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO review VALUES (0, '"+AId+"', '"+songName+"', '"+category+"', '"+duration+"') ";
			int result = stmt.executeUpdate(sql);
			
			
			if(result > 0) {
				
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

	public List<Review> getAllSongs(String id) {
		
		int intId = Integer.parseInt(id);
		
		List<Review> songs = new ArrayList<>();
		
		 try (Connection con = DBConnection.getConnection();
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM review where AId = '"+intId+"'")) {

	            while (rs.next()) {
	                int ReviewId = rs.getInt("ReviewId");
	                int artistId = rs.getInt("AId");
	                String songName = rs.getString("SongName");
	                String category = rs.getString("Category");
	                float duration = rs.getFloat("Duration");

	                Review song = new Review(ReviewId, artistId, songName, category, duration);
	                songs.add(song);
	            }

	        } catch (Exception e) {
	            e.printStackTrace(); // Handle the exception properly (log it, throw a custom exception, etc.)
	        }

	        return songs;
	
	}

}
