package com.revature.beans;

import java.util.Objects;

public class Bicycle{

	private int id;
	private String model;
	private String brand;
	private String description;
	

	public Bicycle() {
		super();
		
		this.model = "";
		this.brand = "";
		this.description= "";
		

	}

	public Bicycle(int id, String order, String model, String brand) {
		super();
		this.id = id;
		
		this.model = "Folding Bike";
		this.brand = "Alan Bike";
		this.description = " ";
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, description, id, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(model, other.model);
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", model=" + model + ", brand=" + brand + ", description=" + description + "]";
	}

	
}

	

	
