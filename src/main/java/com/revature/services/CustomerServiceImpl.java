
package com.revature.services;

import java.util.Set;

import com.revature.beans.Customer;
import com.revature.data.BicycleDAO;
import com.revature.data.CustomerDAO;

public class CustomerServiceImpl implements CustomerUserSevice {

	private CustomerDAO customerDao;
	private BicycleDAO bicycleDao;

	@Override

	public Customer register(Customer newUser) {

		return null;

	}

	@Override

	public Customer logIn(String username, String password) {

		Customer personFromDatabase = customerDao.getByUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		}
		return null;
	}

	@Override

	public Customer updateCustomer(Customer userToUpdate) {

		return null;

	}

	@Override
	public Customer buyBicycle(int BicycleId, Customer newOwner) { 
		
		return null;

	}

	@Override
	public Set<Customer> viewAvailableCustomer() {
		return null;

	}

}
