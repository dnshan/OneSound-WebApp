package lk.oneSound.dao;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lk.oneSound.Model.Artist;
import lk.oneSound.Model.Review;
import lk.oneSound.Utility.DBConnection;

public class ReviewDao {
	
		
	//insert into review table
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

	//read from review table
	public List<Review> getAllSongs(String AId) {
		
		int intAId = Integer.parseInt(AId);
		
		ArrayList<Review> songs = new ArrayList<>();
		
		 try (Connection con = DBConnection.getConnection();
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM review where AId = '"+intAId+"'")) {

	            if (rs.next()) {
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
	
	
	//Update Artist Details
	
	public boolean UpdateReview(String reviewId, String aId, String songName, String category, String duration) {
		boolean isSuccess = false;
		
		try {
			
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			System.out.println("hh 4");		
			
			//int intaId = Integer.parseInt(aId);
			int intreviewid = Integer.parseInt(reviewId);
			float floatduration = Float.parseFloat(duration);

			

			System.out.println( reviewId + aId + songName + category +duration);		

			String sql = "UPDATE review SET SongName = '"+songName+"', Category = '"+category+"', Duration = "+floatduration+" WHERE ReviewId = "+intreviewid+" ";
			int result = stmt.executeUpdate(sql);

			System.out.println(sql);	
			
			System.out.println("result " + result);		

			if (result > 0) {
				System.out.println("hh 5");		

				isSuccess = true;
			}

			else {
				isSuccess = false;
				System.out.println("hh 6");		


			}
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
	}
	
		//Retrieve Review Details
		public  List<Review> getReviewDetails(String reviewId){
			
			int intId = Integer.parseInt(reviewId);
						
			ArrayList<Review> review = new ArrayList<>();
			
			try {

				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM review WHERE ReviewId = '"+intId+"'";
				ResultSet result = stmt.executeQuery(sql);
				
				
					
					  while (result.next()) {
			                int ReviewId = result.getInt("ReviewId");
			                int artistId = result.getInt("AId");
			                String songName = result.getString("SongName");
			                String category = result.getString("Category");
			                float duration = result.getFloat("Duration");

			                Review song = new Review(ReviewId, artistId, songName, category, duration);
			                review.add(song);
					
					
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return review;
			

}
		
		
		//Delete Artist Account
		
		public boolean DeleteReview(String reviewId) {
			
			boolean isSuccess = false;
			
			int intId = Integer.parseInt(reviewId);
			
			try {
				
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String sql = "DELETE FROM review WHERE ReviewId = '"+intId+"'";
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

