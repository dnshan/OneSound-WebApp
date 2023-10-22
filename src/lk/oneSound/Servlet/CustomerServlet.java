package lk.oneSound.Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.CustomerController;

/**
 * Servlet implementation class customerServlet
 * 
 */
@WebServlet("/CustomerServlet")
public final class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerController controller;
//	ICustomer iCustomer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.controller = new CustomerController(request, response);
		this.controller.validate();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
