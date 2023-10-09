package lk.oneSound.Interface;

import java.util.List;

import lk.oneSound.Model.customer;

public interface ICustomer {

	public List<customer> validate(String username, String password);
	
}
