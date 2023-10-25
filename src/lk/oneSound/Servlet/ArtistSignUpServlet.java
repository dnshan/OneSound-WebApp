package lk.oneSound.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.ArtistSignUpController;

/**
 * Servlet implementation class ArtistSignUpServlet
 */
@WebServlet("/ArtistSignUpServlet")
public class ArtistSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ArtistSignUpController controller;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new ArtistSignUpController(request,response);
		this.controller.inserArtist();
		
	}

}
