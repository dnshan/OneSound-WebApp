package lk.oneSound.Interface;

import java.util.ArrayList;


import lk.oneSound.Model.Customer;

public interface ICustomer {

	ArrayList<Customer> validate(String username, String password);
	boolean insertCustomer(String firstname, String lastname, String email, String username, String password);
	
}
