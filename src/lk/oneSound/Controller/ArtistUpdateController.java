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

public class ArtistUpdateController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	ArtistDao dao;
	
	public ArtistUpdateController() {
		
	}
	
	public ArtistUpdateController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new ArtistDao();
//		this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void ArtistUpdate()throws ServletException, IOException{
		

		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String userid = request.getParameter("userid2");
		String firstname = request.getParameter("firstname2");
		String lastname = request.getParameter("lastname2");
		String email = request.getParameter("email2");
		String companyname = request.getParameter("companyname");
		String username = request.getParameter("uid2");
		
		boolean isTrue;
		
		isTrue = dao.UpdateArtist(userid, firstname, lastname, email, companyname, username);
		
		if(isTrue == true) {
			
			List<Artist> artistDetails = dao.getArtistDetails(userid);
			request.setAttribute("artistDetails", artistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ArtistAccount.jsp");
			dis.forward(request, response);
			
		}
		
		else {
			
			List<Artist>artistDetails = dao.getArtistDetails(userid);
			request.setAttribute("artistDetails", artistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("ArtistAccount.jsp");
			dis.forward(request, response);
			
			
		}
	}

	

}
