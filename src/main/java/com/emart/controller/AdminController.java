package com.emart.controller;

import org.mindrot.jbcrypt.BCrypt;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Admin;
import com.emart.exception.AdminNotFoundException;
import com.emart.services.AdminService;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AdminController class handles the API endpoints related to admin
 * operations.
 * 
 * @author Sourabh
 * @version 3.9.10
 * @since 24-05-2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/admins")
public class AdminController {

	private final AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	private static final Logger logger = Logger.getLogger(AdminController.class.getName());

	/**
	 * Get an admin by ID.
	 *
	 * @param id The ID of the admin to retrieve.
	 * @return ResponseEntity with the Admin object if it exists, or a not found
	 *         response if the admin is not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
		logger.log(Level.INFO, "GET /admins/{id}");

		try {
			Admin admin = adminService.getAdminById(id);
			logger.log(Level.INFO, "Admin found: " + admin);
			return ResponseEntity.ok(admin);
		} catch (AdminNotFoundException e) {
			logger.log(Level.WARNING, "Admin not found with ID: " + id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/**
	 * Create a new admin.
	 *
	 * @param admin The Admin object containing the details of the new admin.
	 * @return ResponseEntity with the created Admin object if successful, or an
	 *         internal server error response if the creation fails.
	 */
	@PostMapping("/create")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		logger.log(Level.INFO, "POST /admins/create");

		try {
			Admin createdAdmin = adminService.createAdmin(admin);
			logger.log(Level.INFO, "Admin created successfully: " + createdAdmin);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed to create admin", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Update an existing admin.
	 *
	 * @param id    The ID of the admin to update.
	 * @param admin The updated Admin object.
	 * @return ResponseEntity with the updated Admin object if successful, or a not
	 *         found response if the admin is not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
		logger.log(Level.INFO, "PUT /admins/{id}");

		try {
			Admin updatedAdmin = adminService.updateAdmin(id, admin);
			logger.log(Level.INFO, "Admin updated successfully: " + updatedAdmin);
			return ResponseEntity.ok(updatedAdmin);
		} catch (AdminNotFoundException e) {
			logger.log(Level.WARNING, "Admin not found with ID: " + id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/**
	 * Delete an admin by ID.
	 *
	 * @param id The ID of the admin to delete.
	 * @return ResponseEntity with a success message if the deletion is successful,
	 *         or a not found response if the admin is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
		logger.log(Level.INFO, "DELETE /admins/{id}");

		try {
			adminService.deleteAdmin(id);
			logger.log(Level.INFO, "Admin deleted successfully with ID: " + id);
			return ResponseEntity.ok("Admin deleted successfully");
		} catch (AdminNotFoundException e) {
			logger.log(Level.WARNING, "Admin not found with ID: " + id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

//Admin registration
	@PostMapping("/adminRegister")
	public void adminRegister(@RequestBody Admin admin) {
		logger.log(Level.INFO, "POST /admins/adminRegister");

		// Add admin to the database
		adminService.add(admin);
	}

//Checking BCrypt password
//Parameters:
//- plainPassword: The plain text password to be checked.
//- hashedPassword: The hashed password to compare against.
	private boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			logger.log(Level.INFO, "The password matches.");
			return true;
		} else {
			logger.log(Level.INFO, "The password does not match.");
			return false;
		}
	}

//Admin table check for logged-in email and password
//Parameters:
//- email: The email of the admin to check.
//- plainPassword: The plain text password to be checked.
	public Admin adminCheck(String email, String plainPassword) {
		logger.log(Level.INFO, "Checking admin: email=" + email);

		Admin admin = adminService.getByEmail(email);
		if (admin != null) {
			String hashedPassword = admin.getPassword();
			if (checkPass(plainPassword, hashedPassword)) {
				logger.log(Level.INFO, "Admin found: " + admin);
				return admin;
			}
		}
		logger.log(Level.INFO, "Admin not found or password doesn't match.");
		return null;
	}

//Admin login
//Parameters:
//- admin: The Admin object containing the email and password for login.
	public Object adminLogin(@RequestBody Admin admin) {
		logger.log(Level.INFO, "POST /admins/adminLogin");

		String email = admin.getEmailId();
		String plainPassword = admin.getPassword();
		Admin authenticatedAdmin = adminCheck(email, plainPassword);

		if (authenticatedAdmin != null) {
			logger.log(Level.INFO, "Admin authenticated successfully: " + authenticatedAdmin);
			return authenticatedAdmin;
		} else {
			logger.log(Level.WARNING, "Failed to authenticate admin with email: " + email);
			return null;
		}
	}

//Check if email exists
//Parameters:
//- admin: The Admin object containing the email to check.
	public boolean checkEmail(@RequestBody Admin admin) {
		logger.log(Level.INFO, "Checking email existence: " + admin.getEmailId());

		String email = admin.getEmailId();
		if (adminService.getByEmail(email) != null) {
			logger.log(Level.INFO, "Email exists: " + email);
			return true;
		} else {
			logger.log(Level.INFO, "Email does not exist: " + email);
			return false;
		}
	}

}
