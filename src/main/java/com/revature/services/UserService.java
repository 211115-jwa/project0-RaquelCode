package com.revature.services;

import java.util.Set;

import com.revature.beans.Bicycle;


public interface UserService {
	
	public int addNewBicycle(Bicycle newBicycle);
	public Bicycle updateBicycle(Bicycle bicycleToUpdate);
	public Set<Bicycle> viewAllBicycles();
	public Bicycle viewBicyclesById(int bicicycleId);
    public Set<Bicycle> searchBicyclesByDescription(String description);
	public Set<Bicycle> searchBicyclesByBrand(String brand);
	
	
}
