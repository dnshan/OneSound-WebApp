package lk.oneSound.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.Artist;
import lk.oneSound.dao.ArtistDao;

public class ArtistDeleteController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	ArtistDao dao;
	
	public ArtistDeleteController() {
		
	}
	
	public ArtistDeleteController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new ArtistDao();
		//this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void DeleteArtist()throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userid = request.getParameter("userid2");
		
		boolean isTrue = dao.DeleteArtist(userid);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
			dis.forward(request, response);
			
		}
		
		else {
			
			List<Artist> artistDetails = dao.getArtistDetails(userid);
			request.setAttribute("artistDetails", artistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ArtistAccount.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}
