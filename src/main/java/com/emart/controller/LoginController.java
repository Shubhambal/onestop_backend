package com.emart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emart.entities.Admin;
import com.emart.entities.Customer;
import com.emart.services.AdminService;
import com.emart.services.CustomerManager;

/**
 * The LoginController class handles the API endpoints related to login operations.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerManager customerManager;

	/**
	 * Authenticates the admin user.
	 *
	 * @param admin The admin object containing login credentials.
	 * @return ResponseEntity with the authentication status.
	 */
	@PostMapping("/admin")
	public ResponseEntity<?> authenticateAdmin(@RequestBody Admin admin) {
		return ResponseEntity.status(200).body(adminService.authenticateAdmin(admin));
	}

	/**
	 * Authenticates the customer user.
	 *
	 * @param customer The customer object containing login credentials.
	 * @return ResponseEntity with the authentication status.
	 */
	@PostMapping("/customer")
	public ResponseEntity<?> authenticateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(200).body(customerManager.authenticateCustomer(customer));
	}
}