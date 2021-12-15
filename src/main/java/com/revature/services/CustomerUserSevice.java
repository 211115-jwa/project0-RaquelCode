
  package com.revature.services;
  
  import java.util.Set;
  
  import com.revature.beans.Bicycle; import com.revature.beans.Customer;
  
  public interface CustomerUserSevice {
  
  Customer register(Customer newUser);
  
  Customer logIn(String username, String password);
  
  Customer updateCustomer(Customer userToUpdate);
  
  Customer buyBicycle(int BicycleId, Customer newOwner);
  
  Set<Customer> viewAvailableCustomer();
  
  //Set<Bicycle> searchAvailableBicycleByModels(String model);
  
  
  
  }
 