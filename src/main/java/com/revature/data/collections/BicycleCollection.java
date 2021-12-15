package com.revature.data.collections;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Bicycle;
import com.revature.beans.Customer;
import com.revature.data.BicycleDAO;



public class BicycleCollection implements BicycleDAO {
          
	
	    private Set<Bicycle> allBicycles;
	    private int lastIndex;
		
		public BicycleCollection() {
			allBicycles = new HashSet<>();
			Bicycle bicycle1 = new Bicycle();
			allBicycles.add(bicycle1);
			
			lastIndex = 0;
		
	}
		@Override
		public int create(Bicycle dataToAdd) {
			lastIndex++;
			dataToAdd.setId(lastIndex);
			allBicycles.add(dataToAdd);
			return dataToAdd.getId();
		}

	@Override
	public Bicycle getById(int id) {
		for (Bicycle bicycle : allBicycles) {
			if (bicycle.getId() == id) {
				return bicycle;
			}
		}
		return null;
	}

	@Override
	public Set<Bicycle> getAll() {
		
		
		return allBicycles;
	}

	@Override
	public void update(Bicycle dataToUpdate) {
		Bicycle previousData = getById(dataToUpdate.getId());
		if (previousData != null) {
			allBicycles.remove(previousData);
			allBicycles.add(dataToUpdate);
		}
	}

	@Override
	public void delete(Bicycle dataToDelete) {
		Bicycle previousData = getById(dataToDelete.getId());
		if (previousData != null) {
			allBicycles.remove(previousData);
		}
	}
	@Override
	public Set<Bicycle> getByBrand(String brand) {
		Set<Bicycle> bicycleSet = new HashSet<Bicycle>();
		for (Bicycle bicycle : allBicycles) {
			if (bicycle.getBrand().equals(brand)) {
				bicycleSet.add(bicycle);
			}
		}
		return bicycleSet;
	}

	

	@Override
	public Set<Bicycle> getByModel(String model) {
		Set<Bicycle> bicycleSet = new HashSet<Bicycle>();
		for (Bicycle bicycle : allBicycles) {
			if (bicycle.getModel().equals(model)) {
				bicycleSet.add(bicycle);
			}
		}
		return bicycleSet;
	}


	@Override
	public Set<Bicycle> getByOrder(String order) {
		Set<Bicycle> bicycleSet = new HashSet<Bicycle>();
		for (Bicycle bicycle : allBicycles) {
			if (bicycle.getModel().equals(order)) {
				bicycleSet.add(bicycle);
			}
		}
		return bicycleSet;
	}
	@Override
	public Customer getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
	
	
	


