package lk.oneSound.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.dao.ArtistDao;

public class ArtistSignUpController {
	
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	
	
	public ArtistSignUpController() {
		
	}
	
	public ArtistSignUpController(HttpServletRequest request,HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		this.dispatcher = request.getRequestDispatcher("Login.jsp");
		
	}
	
	public boolean inserArtist() throws ServletException, IOException {

		String FirstName = request.getParameter("artistFirstName");
		String LastName = request.getParameter("artistLastName");
		String email = request.getParameter("artistEmail");
		String companyName = request.getParameter("artistCompanyName");
		String username = request.getParameter("artistUsername");
		String password = request.getParameter("artistPassword");
		
		if (FirstName == null || FirstName.isEmpty() || LastName == null || LastName.isEmpty()
		        || email == null || email.isEmpty() || username == null || username.isEmpty()
		        || password == null || password.isEmpty()) {
		        // If any of the fields are empty or null, redirect back to the signup page.
		        RequestDispatcher dis2 = request.getRequestDispatcher("ArtistSignup.jsp");
		        dis2.forward(request, response);
		        return false; // Validation failed, no need to proceed further.
		    }


		boolean isTrue;

		ArtistDao dao = new ArtistDao();

		isTrue = dao.insertArtist(FirstName, LastName, email,companyName, username, password);

		if (isTrue == true) {

			RequestDispatcher dis = request.getRequestDispatcher("loggedHome.jsp");

			dis.forward(request, response);

		}

		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ArtistSignup.jsp");
			dis2.forward(request, response);

		}

		return isTrue;

		
	}
	

}
