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
		assertNotEquals(1, indexOutput);
	}

	@Test
	public void getByIdWhenIdDoesNotExist() {
		int idInput = 0;
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
	public void getAll() {
		Set<Bicycle> givenOutput = bicycleDao.getAll();
		assertNotNull(givenOutput);
	}

	@Test
	public void getByBrandWhenBrandDoesNotExist() {
		String brandInput = "Imperial";
		Set<Bicycle> bicycleOutput = bicycleDao.getByBrand(brandInput);
		assertTrue(bicycleOutput.isEmpty());
	}

	@Test
	public void getByBrandWhenBrandExists() {
		String brandInput = "Merida";
		int amountOfSchwinn = 1;
		Set<Bicycle> bicycleOutput = bicycleDao.getByBrand(brandInput);
		assertEquals(amountOfSchwinn, bicycleOutput.size());
	}

	@Test
	public void getByDescripitonWhenDescriptionlDoesNotExist() {
		String modelInput = "74-Z";
		Set<Bicycle> bicycleOutput = bicycleDao.getByDescription(modelInput);
		assertTrue(bicycleOutput.isEmpty());
	}

	@Test
	public void getDescripitonWhenDescripitonExists() {
		String modelInput = "bike perfect for commuting";
		int amountOfATX = 1;
		Set<Bicycle> bicycleOutput = bicycleDao.getByDescription(modelInput);
		assertEquals(amountOfATX, bicycleOutput.size());
	}

}