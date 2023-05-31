package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Customer;
import com.emart.repository.CustomerRepository;

@Service
public class CustomerManagerImpl implements CustomerManager {
	
	@Autowired
    CustomerRepository repository;
	
	/**
	 * Add a new customer.
	 * 
	 * @param c The customer to be added.
	 */
	@Override
	public void addCustomer(Customer c) {
		repository.save(c); // Save the customer entity to the repository
	}
	
	/**
	 * Get all customers.
	 * 
	 * @return The list of customers.
	 */
	@Override
	public List<Customer> getCustomers() {
		return repository.findAll(); // Retrieve all customers from the repository
	}
	
	/**
	 * Delete a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer to be deleted.
	 */
	@Override
	public void delete(int customer_Id) {
		repository.deleteById(customer_Id); // Delete the customer from the repository based on ID
	}
	
	/**
	 * Update the wallet balance of a customer.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @param wallet The new wallet balance.
	 */
	@Override
	public void updateWallet(int customer_Id, int wallet) {
	    repository.updateWallet(wallet, customer_Id); // Update the wallet balance of the customer in the repository
	}
	
	/**
	 * Get a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	@Override
	public Optional<Customer> getCustomer(int customer_Id) {
		return repository.findById(customer_Id); // Retrieve the customer from the repository based on ID
	}
	
	/**
	 * Get a customer by username.
	 * 
	 * @param username The username of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	@Override
	public Optional<Object> getCustomer(String username) {
		return repository.getByUserName(username); // Retrieve the customer from the repository based on username
	}
}
