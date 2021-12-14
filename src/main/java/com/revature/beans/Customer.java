package com.revature.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private List<Bicycle> bicycles;

	public Customer() {
		super();

		id = 0;
		firstName = "First Last";
		lastName = "Last Name";
		username = "username";
		password = "password";
		bicycles = new ArrayList<>();

	}

	public Customer(int id, String firstName, String lastName, String username, String password, List<Bicycle> bicycles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.bicycles = bicycles;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bicycle> getBicycles() {
		return bicycles;
	}

	public void setBicycles(List<Bicycle> bicycles) {
		this.bicycles = bicycles;

	}

	@Override
	public int hashCode() {
		return Objects.hash(bicycles, firstName, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(bicycles, other.bicycles) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", bicycles=" + bicycles + "]";
	}

}
