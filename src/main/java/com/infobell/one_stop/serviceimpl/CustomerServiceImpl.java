package com.infobell.one_stop.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.CustomerRepository;
import com.infobell.one_stop.service.CustomerService;

/**
 * Implementation of the CustomerService interface that provides CRUD operations
 * for customers.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Registers a new customer.
	 *
	 * @param customer The customer to be registered.
	 * @return A ResponseEntity with HTTP status OK and a success message.
	 */
	@Override
	public ResponseEntity<String> registerCustomer(Customer customer) {
		// Encoding the password which customer has added
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Customer registered successfully.");
	}

	/**
	 * Retrieves a customer by ID.
	 *
	 * @param customerId The ID of the customer.
	 * @return A ResponseEntity with HTTP status OK and the customer object if
	 *         found, or null if not found.
	 */
	@Override
	public ResponseEntity<Customer> getCustomerById(Integer customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			return ResponseEntity.ok(customer);
		}
		return null;
	}

	/**
	 * Retrieves all customers.
	 *
	 * @return A list of all customers.
	 */
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	/**
	 * Deletes a customer by ID.
	 *
	 * @param customerId The ID of the customer to be deleted.
	 * @return A ResponseEntity with HTTP status OK and a success message if the
	 *         customer is deleted, or a ResponseEntity with HTTP status NOT_FOUND
	 *         and an error message if the customer is not found.
	 */
	@Override
	public ResponseEntity<?> deleteCustomer(Integer customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
			return ResponseEntity.ok().body("Customer deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
	}

	/**
	 * Updates a customer.
	 *
	 * @param customer The updated customer object.
	 * @return A ResponseEntity with HTTP status OK and the updated customer object
	 *         if the customer is updated, or a ResponseEntity with HTTP status
	 *         NOT_FOUND and an error message if the customer is not found.
	 */
	@Override
	public ResponseEntity<?> updateCustomer(Customer customer) {
		if (customerRepository.existsById(customer.getCustomerId())) {
			Customer updatedCustomer = customerRepository.save(customer);
			return ResponseEntity.ok(updatedCustomer);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
	}

}
