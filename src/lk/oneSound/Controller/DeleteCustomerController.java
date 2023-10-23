package lk.oneSound.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Model.Customer;
import lk.oneSound.dao.customerDao;

public class DeleteCustomerController {
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	customerDao dao;
	
	public DeleteCustomerController() {
		
	}
	
	public DeleteCustomerController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dao = new customerDao();
		//this.iCustomer = iCustomer;
		//this.dispatcher = request.getRequestDispatcher("loggedHome.jsp");
	}
	
	public void DeleteCustomer()throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
String userid = request.getParameter("userid2");
		
		boolean isTrue = dao.DeleteCustomer(userid);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
			dis.forward(request, response);
			
		}
		
		else {
			
			List<Customer> userDetails = dao.getCustomerDetails(userid);
			request.setAttribute("userDetails", userDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("userAccount.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}
