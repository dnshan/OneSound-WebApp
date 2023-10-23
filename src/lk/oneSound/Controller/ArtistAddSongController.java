package lk.oneSound.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import lk.oneSound.dao.ReviewDao;

public class ArtistAddSongController {
	
	
	

	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
//	ICustomer iCustomer;
	
	public ArtistAddSongController() {
		
	}
	
	public ArtistAddSongController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
//		this.iCustomer = iCustomer;
		this.dispatcher = request.getRequestDispatcher("SongDetails.jsp");
	}
	
	public boolean addSong() throws ServletException, IOException {

		int AId =Integer.parseInt(request.getParameter("aid"));
	    String SongName = request.getParameter("songname");
	    String Category = request.getParameter("category");
	    String Duration = request.getParameter("duration");
		
		boolean isTrue;
		
		ReviewDao dao = new ReviewDao();
		
		isTrue = dao.addSong(AId, SongName, Category, Duration);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("SongDetails.jsp");
			
			dis.forward(request, response);
			
		}
		
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ArtistAddSong.jsp");
			dis2.forward(request, response);
			
		}
		
		return isTrue;
		
	}
	
	
	
	
	
	
	

}
