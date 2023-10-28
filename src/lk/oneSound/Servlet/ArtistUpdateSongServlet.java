package lk.oneSound.Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lk.oneSound.Controller.ArtistUpdateSongController;


@WebServlet("/ArtistUpdateSongServlet")
public class ArtistUpdateSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ArtistUpdateSongController controller;
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hh 1");		
		this.controller = new  ArtistUpdateSongController(request,response);
		this.controller.ReviewUpdate();
	}

}
