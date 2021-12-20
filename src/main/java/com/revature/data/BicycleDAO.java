package com.revature.data;

import java.util.Set;

import com.revature.beans.Bicycle;

// the PersonDAO extends the GenericDAO in order to
// inherit the CRUD methods, and it sets the type of the
// data to be Person objects
public interface BicycleDAO extends GenericDAO<Bicycle> {
	// here, we could add any additional behaviors that are
	// unique to accessing Person data (not just basic CRUD)
	

	Set<Bicycle> getByDescription(String Description);

	Set<Bicycle> getByBrand(String Brand);

	

	//Set<Bicycle> getByDescripion(String Descripion);
}
