package lk.oneSound.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.customerController;
import lk.oneSound.Interface.ICustomer;

/**
 * Servlet implementation class customerServlet
 * 
 */
@WebServlet("/customerServlet")
public final class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private customerController controller;
//	ICustomer iCustomer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerServlet() {       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.controller = new customerController(request, response);
		this.controller.validate();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
