package com.revature.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Order {
	int orderId;
	int customerId;
	String orderDate;
	String orderStatus;
	
	// Creating a local order
	
	public Order() {
		super();
		
		this.orderId = 2;
		this.customerId = 23;
		this.orderDate= "";
		this.orderStatus = "";
		
	}
	
	// DAO order
	
	public Order(int orderId, int customerId, String orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	


	public int getOrderId() {
		return orderId;
	}
	
	

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setNewOrderId() {
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		setOrderId(n);
	}
	
	public void setTodaysDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String strDate = sdf.format(now);
		
		setOrderDate(strDate);
	}
	
	public void setNewStatus() {
		setOrderStatus("New");
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}