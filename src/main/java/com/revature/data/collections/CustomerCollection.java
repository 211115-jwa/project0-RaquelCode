package com.revature.data.collections;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Customer;

import com.revature.data.CustomerDAO;


//@Deprecated
public class CustomerCollection implements CustomerDAO {
	private Set<Customer> allCustomer;
	private int lastIndex;

	public CustomerCollection() {
		int lastIndex;
		
		allCustomer = new HashSet<>();
		Customer customer1 = new Customer();
		customer1.setUsername("Raquel");
		
		create(customer1);
	}

	@Override
	public int create(Customer dataToAdd) {
		
		lastIndex++;
		dataToAdd.setId(lastIndex);
		allCustomer.add(dataToAdd);
		return dataToAdd.getId();
}

	@Override
	public Customer getById(int id) {
		
		for (Customer customer : allCustomer) {
			if (customer.getId() == id){
				return customer;
			}
		}
	

		return null;
	}

	@Override
	public Set<Customer> getAll() {
		
		return allCustomer;
	}

	@Override
	public void update(Customer dataToUpdate) {
		
		Customer previousData = getById(dataToUpdate.getId());
		if (previousData != null) {
			allCustomer.remove(previousData);
			allCustomer.add(dataToUpdate);
		}

		
	}

	@Override
	public void delete(Customer dataToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	