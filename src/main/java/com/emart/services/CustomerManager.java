package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.emart.entities.Customer;

public interface CustomerManager {
	
	/**
	  * @author  Sourabh
	  * @version 3.9.10
	  * @since   24-05-2023
	 * Add a new customer.
	 * 
	 * @param c The customer to be added.
	 */
	void addCustomer(Customer c);
	
	/**
	 * Get all customers.
	 * 
	 * @return The list of customers.
	 */
	List<Customer> getCustomers();
	
	/**
	 * Delete a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer to be deleted.
	 */
	void delete(int customer_Id);
	
	/**
	 * Update the wallet balance of a customer.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @param wallet The new wallet balance.
	 */
	void updateWallet(int customer_Id, int wallet);
	
	/**
	 * Get a customer by ID.
	 * 
	 * @param customer_Id The ID of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	Optional<Customer> getCustomer(int customer_Id);
	
	/**
	 * Get a customer by username.
	 * 
	 * @param username The username of the customer.
	 * @return An optional containing the customer, or an empty optional if not found.
	 */
	Optional<Object> getCustomer(String username);
	
	/**
	 * Authenticate customer by username and password.
	 * 
	 * @param customer details such as username and password .
	 * @return An ResponseEntity containing the string, based on customer provide
	 *         valid username, password or not.
	 */
	ResponseEntity<String> authenticateCustomer(Customer customer);

	/**
	 * This method will check weather the username which has been added by the
	 * customer is already present in database or not.
	 * 
	 * @return If it is present then it will return otherwise false.
	 * @param c The customer to be added.
	 */
	boolean isUsernameTaken(String username);
}
