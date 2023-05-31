package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Customer;
import com.emart.exception.CustomerNotFoundException;
import com.emart.services.CustomerManager;

/**
 * The CustomerController class handles the API endpoints related to Customer operations.
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerManager manager;

    /**
     * Retrieves all the customers.
     *
     * @return ResponseEntity with the list of Customer objects if they exist,
     *         or a no content response if no customers are found.
     */
    @GetMapping(value = "api/customers")
    public ResponseEntity<List<Customer>> showCustomers() {
        List<Customer> customers = manager.getCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

    /**
     * Retrieves a specific customer by their ID.
     *
     * @param customer_Id The ID of the customer to retrieve.
     * @return ResponseEntity with the Customer if found,
     *         or throws CustomerNotFoundException if the customer is not found.
     */
    @GetMapping(value = "api/customerById/{customer_Id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customer_Id) {
        try {
            Optional<Customer> customer = manager.getCustomer(customer_Id);
            return customer.map(ResponseEntity::ok).orElseThrow(() ->
                    new CustomerNotFoundException("Customer not found with ID: " + customer_Id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    /**
     * Removes a customer by their ID.
     *
     * @param customer_Id The ID of the customer to remove.
     * @return ResponseEntity with a success message if the customer is deleted successfully,
     *         or an error message if the customer deletion fails.
     */
    @DeleteMapping(value = "api/customer/{customer_Id}")
    public ResponseEntity<String> removeCustomer(@PathVariable int customer_Id) {
        try {
            manager.delete(customer_Id);
            return ResponseEntity.ok("Customer deleted successfully.");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found with ID: " + customer_Id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete customer: " + e.getMessage());
        }
    }

    /**
     * Updates a customer's wallet balance by their ID.
     *
     * @param customer     The updated Customer object.
     * @param customer_Id  The ID of the customer to update.
     * @return ResponseEntity with a success message if the customer is updated successfully,
     *         or an error message if the customer update fails.
     */
    @PutMapping(value = "api/customer/{customer_Id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable int customer_Id) {
        try {
            manager.updateWallet(customer_Id, customer.getwallet());
            return ResponseEntity.ok("Customer updated successfully.");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found with ID: " + customer_Id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update customer: " + e.getMessage());
        }
    }

    /**
     * Adds a new customer.
     *
     * @param customer The Customer object to add.
     * @return ResponseEntity with a success message if the customer is added successfully,
     *         or an error message if the customer addition fails.
     */
    @PostMapping(value = "api/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            manager.addCustomer(customer);
            return ResponseEntity.ok("Customer added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add customer: " + e.getMessage());
        }
    }

    /**
     * Retrieves a customer by their username.
     *
     * @param username The username of the customer to retrieve.
     * @return ResponseEntity with the Customer if found,
     *         or a no content response if the customer is not found.
     */
    @GetMapping(value = "api/getByUserName/{username}")
    public ResponseEntity<Object> getCustomer(@PathVariable String username) {
        try {
            Optional<Object> customer = manager.getCustomer(username);
            return customer.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
