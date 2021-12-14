package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;

public class BicycleUserServiceImpl implements BicycleUserService {
	
	private BicycleDAO bicycleDao;
	
	
	@Override
	public int addNewBicycle(Bicycle newBicycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bicycle updateBicycle(Bicycle bicycleToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Set<Bicycle> viewAllBicycles() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Bicycle viewBicyclesById(int id) {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public Set<Bicycle> searchBicyclesByModel(String model) {
		Set<Bicycle> bicyclesFromDatabase = new HashSet<Bicycle>();
		bicyclesFromDatabase = bicycleDao.getByModel(model);
		if (bicyclesFromDatabase != null) {
			return bicyclesFromDatabase;
		}
		return null;
		
		
		
	}
	
	
  @Override
	public Set<Bicycle> searchBicyclesByOrder(String model) {
		Set<Bicycle> bicyclesFromDatabase = new HashSet<Bicycle>();
		bicyclesFromDatabase = bicycleDao.getByOrder(model);
		if (bicyclesFromDatabase != null) {
			return bicyclesFromDatabase;
		}
		return null;
	}
	
	
	
	

}
