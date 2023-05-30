package com.infobell.one_stop.service;

import java.util.List;

import com.infobell.one_stop.model.Customer;

public interface CustomerService {
    Customer getCustomerById(int id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(int id, Customer customer);

    String deleteCustomer(int id);
    
    
    
    void add(Customer customer);
	void modify(Customer customer);
	void removeById(int id);
	Customer getById(int id);
	List<Customer> getAll();
	String hashPassword(String plainTextPassword);
static Customer getByEmail(String email) {
	// TODO Auto-generated method stub
	return null;
}
		
}
