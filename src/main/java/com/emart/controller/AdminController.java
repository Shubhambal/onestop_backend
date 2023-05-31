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

/**
 * The AdminController class handles the API endpoints related to admin operations.
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

    /**
     * Get an admin by ID.
     *
     * @param id The ID of the admin to retrieve.
     * @return ResponseEntity with the Admin object if it exists,
     *         or a not found response if the admin is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Create a new admin.
     *
     * @param admin The Admin object containing the details of the new admin.
     * @return ResponseEntity with the created Admin object if successful,
     *         or an internal server error response if the creation fails.
     */
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        try {
            Admin createdAdmin = adminService.createAdmin(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Update an existing admin.
     *
     * @param id    The ID of the admin to update.
     * @param admin The updated Admin object.
     * @return ResponseEntity with the updated Admin object if successful,
     *         or a not found response if the admin is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Delete an admin by ID.
     *
     * @param id The ID of the admin to delete.
     * @return ResponseEntity with a success message if the admin is deleted successfully,
     *         or a not found response if the admin is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
        try {
            String result = adminService.deleteAdmin(id);
            return ResponseEntity.ok(result);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

   

 // Admin registration
    @PostMapping("/adminRegister")
    public void adminRegister(@RequestBody Admin admin) {
        adminService.add(admin);
    }

    // Checking BCrypt password
    // Parameters:
    // - plainPassword: The plain text password to be checked.
    // - hashedPassword: The hashed password to compare against.
    static private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            System.out.println("The password matches.");
            return true;
        } else {
            System.out.println("The password does not match.");
            return false;
        }
    }

    // Admin table check for logged-in email and password
    // Parameters:
    // - email: The email of the admin to check.
    // - plainPassword: The plain text password to be checked.
    public Admin adminCheck(String email, String plainPassword) {
        Admin admin = adminService.getByEmail(email);
        if (admin != null) {
            String hashedPassword = admin.getPassword();
            if (checkPass(plainPassword, hashedPassword)) {
                return admin;
            }
        }
        return null;
    }

    // Admin login
    // Parameters:
    // - admin: The Admin object containing the email and password for login.
    public Object adminLogin(@RequestBody Admin admin) {
        String email = admin.getEmailId();
        String plainPassword = admin.getPassword();
        if (adminCheck(email, plainPassword) != null) {
            return adminCheck(email, plainPassword);
        } else {
            return null;
        }
    }

    // Check if email exists
    // Parameters:
    // - admin: The Admin object containing the email to check.
    public boolean checkEmail(@RequestBody Admin admin) {
        String email = admin.getEmailId();
        if (adminService.getByEmail(email) != null) {
            return true;
        }
        return false;
    }

}
