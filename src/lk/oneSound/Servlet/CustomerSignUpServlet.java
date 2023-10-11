package lk.oneSound.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.Controller.CustomerSignUpController;
import lk.oneSound.Controller.customerController;

/**
 * Servlet implementation class CustomerSignUpServlet
 */
@WebServlet("/CustomerSignUpServlet")
public class CustomerSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerSignUpController controller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSignUpServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.controller = new CustomerSignUpController(request, response);
		this.controller.insertCustomer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
