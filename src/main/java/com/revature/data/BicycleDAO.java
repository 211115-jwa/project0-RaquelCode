package com.revature.data;

import java.util.Set;

import com.revature.beans.Bicycle;


public interface BicycleDAO extends GenericDAO<Bicycle> {
	

	Set<Bicycle> getByDescription(String Description);

	Set<Bicycle> getByBrand(String Brand);

	

	
}
