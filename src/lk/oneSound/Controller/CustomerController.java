package lk.oneSound.Controller;

import java.io.IOException;



import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.Artist;
import lk.oneSound.Model.Customer;
import lk.oneSound.dao.ArtistDao;
import lk.oneSound.dao.customerDao;


public class CustomerController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	customerDao dao;
	ArtistDao artistdao;
//	ICustomer iCustomer;
	
	public CustomerController() {
		
	}
	
	public CustomerController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new customerDao();
		this.artistdao = new ArtistDao();
//		this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void validate() throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		String page = request.getParameter("page").toString();
		
		System.out.println(page);
		
		if(username == null || username.isEmpty()) {
			System.out.println("Hi");
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null) {
			    for (Cookie cookie : cookies) {
			        if (cookie.getName().equals("username")) {
			            username = cookie.getValue();
			            System.out.println("username" + username);
			        } 
			        
			        if (cookie.getName().equals("password")) {
			            password = cookie.getValue();
			            System.out.println("password" + password);
			        }
			    }
			}

			
		} else {
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);

			// Set the maximum age for the cookies (in seconds)
			usernameCookie.setMaxAge(60 * 60 );  // 1 hour
			passwordCookie.setMaxAge(60 * 60);  // 1 hour
			
			// Add the cookies to the response
    		response.addCookie(usernameCookie);
    		response.addCookie(passwordCookie);
		}
		
		
		try {
		ArrayList<Customer> userDetails = dao.validate(username, password);
		ArrayList<Artist>artistDetails = artistdao.validate(username, password);
		
		
		if (userDetails != null && !userDetails.isEmpty()) {
            // User is authenticated
            request.setAttribute("userDetails", userDetails);
            
            if("01".equals(page.trim())) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("userAccount.jsp");
            // Forward to the user's home page
            dispatcher.forward(request, response);
            }
            
            else {
            	
            	dispatcher = request.getRequestDispatcher("CustomerLoggedHome.jsp");
            	// Forward to the logged home page
                dispatcher.forward(request, response);
            	
            	
            }
		
		} 
		
		else if (artistDetails != null && !artistDetails.isEmpty()) {
			
			 request.setAttribute("artistDetails", artistDetails);
			 
			 if("01".equals(page.trim())) {
	         RequestDispatcher dispatcher = request.getRequestDispatcher("ArtistAccount.jsp");
	         dispatcher.forward(request, response);
			 }
			 
			 else {
				 
				 	dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	            	// Forward to the logged home page
	                dispatcher.forward(request, response);
	            	
				 
			 }
			
		}
		
		
		
		else {
            // Authentication failed
			//out.println("<script type='text/javascript'>");
			//out.println("alert('Your username or password is incorrect');");
			//out.println("location='Login.jsp'");
			//out.println("</script>");
			
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
