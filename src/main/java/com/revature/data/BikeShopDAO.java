package com.revature.data;

import java.util.Set;

import com.revature.beans.BikeShop;


public interface BikeShopDAO extends GenericDAO<BikeShop>{
	
	public Set<BikeShop> getByStatus(String status);

}
