package lk.oneSound.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.ArtistDeleteController;

/**
 * Servlet implementation class DeleteArtistServlet
 */
@WebServlet("/DeleteArtistServlet")
public class DeleteArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistDeleteController controller;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.controller = new ArtistDeleteController(request,response);
		this.controller.DeleteArtist();
		
		
	}

}
