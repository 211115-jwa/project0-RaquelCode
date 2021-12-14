package com.revature.services;

import java.util.Set;

import com.revature.beans.Bicycle;

public interface BicycleUserService {

	Bicycle updateBicycle(Bicycle bicycleToUpdate);

	int addNewBicycle(Bicycle newBicycle);

	Set<Bicycle> viewAllBicycles();

	Bicycle viewBicyclesById(int id);

	Set<Bicycle> searchBicyclesByBrand(String brand);

	Set<Bicycle> searchBicyclesByModel(String model);

	Set<Bicycle> searchBicyclesByOrder(String model);

}
