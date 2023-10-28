package lk.oneSound.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.ArtistDeleteSongController;



@WebServlet("/ArtistDeleteSongServlet")
public class ArtistDeleteSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ArtistDeleteSongController controller;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new  ArtistDeleteSongController(request,response);
		this.controller.DeleteArtist();
	}

}
