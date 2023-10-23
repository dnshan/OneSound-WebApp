package lk.oneSound.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.ArtistAddSongController;

/**
 * Servlet implementation class ArtistAddSongServlet
 */
@WebServlet("/ArtistAddSongServlet")
public class ArtistAddSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArtistAddSongController controller;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistAddSongServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.controller = new ArtistAddSongController(request, response);
		this.controller.addSong();
	}

}
