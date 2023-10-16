package lk.oneSound.Interface;

import java.util.List;


import lk.oneSound.Model.customer;

public interface ICustomer {

	List<customer> validate(String username, String password);
	boolean insertCustomer(String firstname, String lastname, String email, String username, String password);
	
}
