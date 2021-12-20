package com.revature.beans;

import java.util.Objects;

public class Bicycle {
	private int id;
	private String Description;
	private String Brand;
	
	
	public Bicycle () {
		id = 0;
		Description = "";
		Brand = "";
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getBrand() {
		return Brand;
	}


	public void setBrand(String brand) {
		Brand = brand;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Brand, Description, id);
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
		return Objects.equals(Brand, other.Brand) && Objects.equals(Description, other.Description) && id == other.id;
	}


	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", Description=" + Description + ", Brand=" + Brand + "]";
	}


	


	

}