package lk.oneSound.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lk.oneSound.dao.customerDao;

public class CustomerSignUpController {

	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
//	ICustomer iCustomer;

	public CustomerSignUpController() {

	}

	public CustomerSignUpController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
//		this.iCustomer = iCustomer;
		this.dispatcher = request.getRequestDispatcher("Login.jsp");
	}

	public boolean insertCustomer() throws ServletException, IOException {

		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		if (FirstName == null || FirstName.isEmpty() || LastName == null || LastName.isEmpty()
		        || email == null || email.isEmpty() || username == null || username.isEmpty()
		        || password == null || password.isEmpty()) {
		        // If any of the fields are empty or null, redirect back to the signup page.
		        RequestDispatcher dis2 = request.getRequestDispatcher("UserSignup.jsp");
		        dis2.forward(request, response);
		        return false; // Validation failed, no need to proceed further.
		    }


		boolean isTrue;

		customerDao dao = new customerDao();

		isTrue = dao.insertCustomer(FirstName, LastName, email, username, password);

		if (isTrue == true) {

			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");

			dis.forward(request, response);

		}

		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("UserSignup.jsp");
			dis2.forward(request, response);

		}

		return isTrue;

	}

}
