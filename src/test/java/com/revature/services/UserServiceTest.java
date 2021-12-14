package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;

  @ExtendWith (MockitoExtension.class)
  
public class UserServiceTest {
	
	@Mock
	private BicycleDAO bicycleDao;
	
	@InjectMocks
	private BicycleUserServiceImpl userServ = new BicycleUserServiceImpl();
	
	
	@Test
	public void searchBicyclesByModelExists() {
		String model = "Test Model";
		
		Bicycle mockBicycle = new Bicycle();
		mockBicycle.setModel(model);
		Set<Bicycle> mockBicycleSet = new HashSet<Bicycle>();
		mockBicycleSet.add(mockBicycle);
		
		when(bicycleDao.getByModel(model)).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByModel(model);
		
		assertEquals(actualBicycleSet, mockBicycleSet);
	}
	
	@Test
	public void searchBicyclesByModelDoesNotExist() {
		String modelDoesNotExist = "Not Test Model";
		
		Set<Bicycle> mockBicycleSet = null;
		
		when(bicycleDao.getByModel(modelDoesNotExist)).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByModel(modelDoesNotExist);
		assertNull(actualBicycleSet);
	}
	
	@Test
	public void searchBicyclesByBrandExists() {
		String brand = "Test Brand";
		
		Bicycle mockBicycle = new Bicycle();
		mockBicycle.setBrand(brand);
		Set<Bicycle> mockBicycleSet = new HashSet<Bicycle>();
		mockBicycleSet.add(mockBicycle);
		
		when(bicycleDao.getByBrand(brand)).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByBrand(brand);
		
		assertEquals(actualBicycleSet, mockBicycleSet);
	}
}