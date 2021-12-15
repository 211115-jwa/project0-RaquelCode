
package com.revature.DataTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;
import com.revature.data.postgres.BicyclePostgres;


public class BicycleDAOTest {
	
	private BicycleDAO bicycleDao = new BicyclePostgres();

	@Test
	public void create() {
		Bicycle dataInput = new Bicycle();
		int indexOutput = bicycleDao.create(dataInput);
		assertEquals(1, indexOutput);
	}
	
	@Test
	public void getByIdWhenIdDoesNotExist() {
		int idInput = -1;
		Bicycle bicycleOutput = bicycleDao.getById(idInput);
		assertNull(bicycleOutput);
	}
	
	@Test
	public void getByIdWhenIdExists() {
		int idInput = 1;
		Bicycle bicycleOutput = bicycleDao.getById(idInput);
		assertEquals(1, bicycleOutput.getId());
	}
	
	@Test
	public void getByBrandWhenBrandDoesNotExist() {
		String brandInput = "Imperial";
		Set<Bicycle> bicycleOutput = bicycleDao.getByBrand(brandInput);
		assertTrue(bicycleOutput.isEmpty());
	}
	
	@Test
	public void getByBrandWhenBrandExists() {
		String brandInput = "Schwinn";
		int amountOfSchwinn = 1;
		Set<Bicycle> bicycleOutput = bicycleDao.getByBrand(brandInput);
		assertEquals(amountOfSchwinn, bicycleOutput.size());
	}
	
	@Test
	public void getByModelWhenModelDoesNotExist() {
		String modelInput = "74-Z";
		Set<Bicycle> bicycleOutput = bicycleDao.getByModel(modelInput);
		assertTrue(bicycleOutput.isEmpty());
	}
	
	@Test
	public void getByModelWhenModelExists() {
		String modelInput = "ATX";
		int amountOfATX = 1;
		Set<Bicycle> bicycleOutput = bicycleDao.getByModel(modelInput);
		assertEquals(amountOfATX, bicycleOutput.size());
	}
	

	@Test
	public void getByOrderWhenOrderDoesNotExist() {
		String orderInput = "74-Z";
		Set<Bicycle> bicycleOutput = bicycleDao.getByOrder(orderInput);
		assertTrue(bicycleOutput.isEmpty());
	}
	
	@Test
	public void getByOrderWhenOrderExists() {
		String orderInput = "ATX";
		int amountOfATX = 1;
		Set<Bicycle> bicycleOutput = bicycleDao.getByModel(orderInput);
		assertEquals(amountOfATX, bicycleOutput.size());
	}
	
}