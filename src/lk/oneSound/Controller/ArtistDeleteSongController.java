package lk.oneSound.Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.Review;
import lk.oneSound.dao.ReviewDao;

public class ArtistDeleteSongController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	ReviewDao dao;
	
	public ArtistDeleteSongController() {
		
	}
	
	public ArtistDeleteSongController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new ReviewDao();
		//this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void DeleteArtist()throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String reviewid = request.getParameter("Review Id");
		
		boolean isTrue = dao.DeleteReview(reviewid);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("ArtistAddSong.jsp");
			dis.forward(request, response);
			
		}
		
		else {
			
			List<Review> review = dao.getReviewDetails(reviewid);
			request.setAttribute("artistDetails", review);
			
			RequestDispatcher dis = request.getRequestDispatcher("SongDetails.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}

