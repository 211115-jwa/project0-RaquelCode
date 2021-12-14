package com.revature.beans;

import java.util.Objects;

public class Bicycle{

	private int id;
	private String order;
	private String model;
	private String brand;
	
	

	public Bicycle() {
		super();
		this.order = "";
		this.model = "";
		this.brand = "";
		
		

	}

	public Bicycle(int id, String order, String model, String brand) {
		super();
		this.id = id;
		this.order = "Date and Number";
		this.model = "Folding Bike";
		this.brand = "Alan Bike";
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String name) {
		this.order = name;
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

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, order);
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
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(model, other.model)
				&& Objects.equals(order, other.order);
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", order=" + order + ", model=" + model + ", brand=" + brand + "]";
	}

	

	
}

	

	
