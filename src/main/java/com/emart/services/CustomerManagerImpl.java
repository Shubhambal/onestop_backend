package com.emart.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.emart.entities.Customer;
import com.emart.repository.CustomerRepository;

@Service
public class CustomerManagerImpl implements CustomerManager {
	
	 /** @author  Sourabh
	 * @version 3.9.10
	 * @since   24-05-2023*/
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
    CustomerRepository repository;

	/**
	 * This method will check weather the username which has been added by the customer is already present in database or not.
	 * 
	 * @return If it is present then it will return otherwise false.
	 * @param c The customer to be added.
	 */
	public boolean isUsernameTaken(String username) {
        Optional<Customer> existingUser = Optional.ofNullable(repository.findByUsername(username));
        return existingUser.isPresent();
    }
	
	/**
	 * Add a new customer.
	 * 
	 * @param c The customer to be added.
	 */
	@Override
	public void addCustomer(Customer customer) {
		customer.setpassword(passwordEncoder.encode(customer.getpassword()));
		repository.save(customer); // Save the customer entity to the repository
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
	
	/**
	 * Authenticate customer by username and password.
	 * 
	 * @param customer details such as username and password .
	 * @return An ResponseEntity containing the string, based on customer provide
	 *         valid username, password or not.
	 */

	@Override
	public ResponseEntity<String> authenticateCustomer(Customer customer) {
		try {
			Optional<Customer> opCustomer = Optional.ofNullable(repository.findByUsername(customer.getusername()));
			if (opCustomer.isPresent()) {
				Customer dbCustomer = opCustomer.get();
				if (bCryptPasswordEncoder.matches(customer.getpassword(), dbCustomer.getpassword()))
					return ResponseEntity.status(HttpStatus.OK).body("Successfully Logged In.");
//					return ResponseEntity.ok("Successfully Logged In.");
				else
//					return ResponseEntity.ok("Wrong Password. Please try again!");
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Password. Please try again!");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer is not registered yet.");
//			return ResponseEntity.ok("Customer is not registered yet.");
		} catch (Exception e) {
			// Handle the exception here or log it for troubleshooting
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred during authentication.");
		}
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
	
}
