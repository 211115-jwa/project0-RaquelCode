package com.revature.data;

import java.util.Set;

import com.revature.beans.Bicycle;


public interface BicycleDAO extends GenericDAO<Bicycle>{
	
	Set<Bicycle> getByBrand(String brand);

	Set<Bicycle> getByModel(String model);

	Set<Bicycle> getByOrder(String order);

}
