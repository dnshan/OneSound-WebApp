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

public class ArtistUpdateSongController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	ReviewDao dao;
	
	public ArtistUpdateSongController() {
		
	}
	
	public ArtistUpdateSongController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new ReviewDao();
//		this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void ReviewUpdate()throws ServletException, IOException{
		

		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ReviewId =request.getParameter("ReviewId");
		String AId = request.getParameter("ArtistID");
	    String SongName = request.getParameter("SongName");
	    String Category = request.getParameter("Category");
	    String Duration = request.getParameter("Duration");
		
		boolean isTrue;
		
		isTrue = dao.UpdateReview(ReviewId, AId, SongName, Category, Duration);
		System.out.println("hh 2");		
		
		if(isTrue == true) {
			
			List<Review> songs = dao.getReviewDetails(ReviewId);
			request.setAttribute("songs", songs);
			System.out.println("hh 3");		
			RequestDispatcher dis = request.getRequestDispatcher("SongDetails.jsp");
			dis.forward(request, response);
		}
		
		else {
			
			
			List<Review> songs = dao.getReviewDetails(ReviewId);
			request.setAttribute("songs", songs);
			System.out.println("hh 8");		
			RequestDispatcher dis = request.getRequestDispatcher("SongDetails.jsp");
			dis.forward(request, response);
			
			
		}
		
		
		
	}

	
	

}
