package com.revature.data;

import java.util.Set;

import com.revature.beans.Customer;

	
	

public interface CustomerDAO extends GenericDAO<Customer>{
	
	public Set<Customer> getByStatus(String status);

}



