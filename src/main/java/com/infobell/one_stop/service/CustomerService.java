package com.infobell.one_stop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.infobell.one_stop.model.Customer;

public interface CustomerService {

	public ResponseEntity<String>  registerCustomer(Customer customer);

	public ResponseEntity<Customer> getCustomerById(Integer customerId);

	public List<Customer> getAllCustomer();
	
	public ResponseEntity<?> deleteCustomer(Integer customerId);

	public ResponseEntity<?> updateCustomer(Customer customer);

}
