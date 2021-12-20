package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Bicycle;

import com.revature.data.BicycleDAO;

import com.revature.data.postgres.BicyclePostgres;


public class UserServiceImpl implements UserService {
	private BicycleDAO bicycleDao = new BicyclePostgres();
	

	@Override
	public int addNewBicycle(Bicycle newBicycle) {
		return bicycleDao.create(newBicycle);
		
	}

	@Override
	public Bicycle updateBicycle(Bicycle bicycleToUpdate) {
		Bicycle bicycleFromDatabase = bicycleDao.getById(bicycleToUpdate.getId());
		if (bicycleFromDatabase != null) {
			bicycleDao.update(bicycleToUpdate);
			return bicycleDao.getById(bicycleToUpdate.getId());
		}
		return null;
	}

	
	@Override
	public Bicycle viewBicyclesById(int id) {
		
		
		return bicycleDao.getById(id);
		
	}




	@Override
	public Set<Bicycle> searchBicyclesByDescription(String description) {
		
		Set<Bicycle> bicyclesFromDatabase = new HashSet<Bicycle>();
		bicyclesFromDatabase = bicycleDao.getByDescription(description);
		if (bicyclesFromDatabase != null) {
			return bicyclesFromDatabase;
		}
		// TODO Auto-generated method stub
		return bicyclesFromDatabase;
	}

	@Override
	
	  public Set<Bicycle> viewAllBicycles() { 
		
	  return bicycleDao.getAll(); 
	  
	}
	 

	
	@Override
	public Set<Bicycle> searchBicyclesByBrand(String brand) {
		Set<Bicycle> bicyclesFromDatabase = new HashSet<Bicycle>();
		bicyclesFromDatabase = bicycleDao.getByBrand(brand);
		if (bicyclesFromDatabase != null) {
			return bicyclesFromDatabase;
		}
		return null;
	}

	

	

	

}
