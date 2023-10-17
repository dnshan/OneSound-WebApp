package lk.oneSound.Controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.customer;
import lk.oneSound.dao.customerDao;


public class customerController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
//	ICustomer iCustomer;
	
	public customerController() {
		
	}
	
	public customerController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
//		this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void validate() throws ServletException, IOException {

		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		
		
		try {
		List<customer> userDetails = new customerDao().validate(username, password);
		request.setAttribute("userDetails", userDetails);
		
		
		if (userDetails != null && !userDetails.isEmpty()) {
            // User is authenticated
            request.setAttribute("userDetails", userDetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("loggedHome.jsp"); // Forward to the user's home page
            dispatcher.forward(request, response);
        
		
		} else {
            // Authentication failed
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp"); // Forward to the login page with an error message
            request.setAttribute("loginError", "Invalid username or password.");
            dispatcher.forward(request, response);
        }
		
		
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		//dispatcher.forward(request, response);
		
	}
	

}
