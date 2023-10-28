package lk.oneSound.Controller;

import lk.oneSound.Model.Review;
import lk.oneSound.dao.ReviewDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ArtistReadSongController {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public ArtistReadSongController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void getAndSetSongs() throws ServletException, IOException {
    	
//    	PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
		
		String AId = request.getParameter("aid");
    	
        ReviewDao reviewDao = new ReviewDao();
        List<Review> songs = reviewDao.getAllSongs(AId);
        
        if(songs != null || songs.isEmpty()) {
        // Set the list of songs as an attribute in the request object
        request.setAttribute("songs", songs);
        // Forward the request to the JSP page where you want to display the songs
        RequestDispatcher dis = request.getRequestDispatcher("SongDetails.jsp");
        dis.forward(request, response);
        }
       
        
   
        try {
            request.getRequestDispatcher("SongDetails.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly (log it, throw a custom exception, etc.)
        }
    }
}
