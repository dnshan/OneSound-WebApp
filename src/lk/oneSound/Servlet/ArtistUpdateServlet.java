package lk.oneSound.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.ArtistUpdateController;

@WebServlet("/ArtistUpdateServlet")
public class ArtistUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistUpdateController controller;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.controller = new ArtistUpdateController(request,response);
		this.controller.ArtistUpdate();
		
	}

}
