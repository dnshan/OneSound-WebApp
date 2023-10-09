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
	
	public customerController() {
		
	}
	
	public customerController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void validate() throws ServletException, IOException {

		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		try {
		List<customer> userDetails = customerDao.validate(username, password);
		request.setAttribute("userDetails", userDetails);
		
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		dispatcher.forward(request, response);
		
	}
	

}
