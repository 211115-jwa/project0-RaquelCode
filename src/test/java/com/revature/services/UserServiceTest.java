package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private BicycleDAO bicycleDao;
	
	@InjectMocks
	private UserService userServ = new UserServiceImpl();
	
	
	@Test
	public void searchBicyclesByDescriptionExists() {
		String Description = "Test Model";
		
		Bicycle mockBicycle = new Bicycle();
		mockBicycle.setDescription(Description);
		Set<Bicycle> mockBicycleSet = new HashSet<Bicycle>();
		mockBicycleSet.add(mockBicycle);
		
		when(bicycleDao.getByDescription(Description)).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByDescription(Description);
		
		assertEquals(actualBicycleSet, mockBicycleSet);
	}
	
	@Test
	public void searchBicyclesByDescriptionDoesNotExist() {
		String descriptionDoesNotExist = "Not Test Model";
		
		when(bicycleDao.getByDescription(descriptionDoesNotExist)).thenReturn(Collections.emptySet());
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByDescription(descriptionDoesNotExist);
		assertTrue(actualBicycleSet.isEmpty());
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
		
	@Test
	public void searchBicyclesByBrandDoesNotExist() {
		String brandDoesNotExist = "Not Test Brand";
		
		Set<Bicycle> mockBicycleSet = null;
		
		when(bicycleDao.getByBrand(brandDoesNotExist)).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.searchBicyclesByBrand(brandDoesNotExist);
		assertNull(actualBicycleSet);
	}
	
	@Test
	public void viewBicyclesByIdSuccessfully() {
		Bicycle bicycle = new Bicycle();
		bicycle.setId(15);
		
		when(bicycleDao.getById(15)).thenReturn(bicycle);
		
		Bicycle actualBicycle = userServ.viewBicyclesById(15);
		assertEquals(bicycle, actualBicycle);
	}
	
	@Test
	public void viewBicyclesByIdWrong() {
		when(bicycleDao.getById(15)).thenReturn(null);
		
		Bicycle actualBicycle = userServ.viewBicyclesById(15);
		assertNull(actualBicycle);
	}
	
	@Test
	public void viewAllBicycles() {
		Set<Bicycle> mockBicycleSet = new HashSet<Bicycle>();
		
		when(bicycleDao.getAll()).thenReturn(mockBicycleSet);
		
		Set<Bicycle> actualBicycleSet = userServ.viewAllBicycles();
		assertNotNull(actualBicycleSet);
	}
	
	@Test
	public void updateBicycleSuccessfully() {
		Bicycle updatedBicycle = new Bicycle();
		updatedBicycle.setId(15);
		updatedBicycle.setDescription("Fontana Inspired");
		
		when(bicycleDao.getById(15)).thenReturn(updatedBicycle);
		doNothing().when(bicycleDao).update(Mockito.any(Bicycle.class));
		
		Bicycle actualBicycle = userServ.updateBicycle(updatedBicycle);
		
		assertEquals(updatedBicycle, actualBicycle);
	}
	
	@Test
	public void updateBicycleWrong() {
		Bicycle mockBicycle = new Bicycle();
		mockBicycle.setId(15);
		
		when(bicycleDao.getById(15)).thenReturn(mockBicycle);
		doNothing().when(bicycleDao).update(Mockito.any(Bicycle.class));

		Bicycle updatedBicycle = new Bicycle();
		updatedBicycle.setId(15);
		updatedBicycle.setDescription("Fontana Inspired");
		
		Bicycle actualBicycle = userServ.updateBicycle(updatedBicycle);
		
		assertNotEquals(updatedBicycle, actualBicycle);
	}
	
	@Test
	public void addNewBicycleSuccessfully() {
		Bicycle bicycle = new Bicycle();
		
		when(bicycleDao.create(bicycle)).thenReturn(16);
		
		int newId = userServ.addNewBicycle(bicycle);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addNewBicycleWrong() {
		Bicycle bicycle = new Bicycle();
		
		when(bicycleDao.create(bicycle)).thenReturn(0);
		
		int newId = userServ.addNewBicycle(bicycle);
		
		assertEquals(0, newId);
	}
	
}