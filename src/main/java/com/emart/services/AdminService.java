package com.emart.services;

import com.emart.entities.Admin;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface AdminService {

    /**
      * @author  Sourabh
      * @version 3.9.10
      * @since   24-05-2023
     * Retrieves an admin by ID.
     *
     * @param id The ID of the admin to retrieve.
     * @return The retrieved admin.
     */
    Admin getAdminById(int id);

    /**
     * Creates a new admin.
     *
     * @param admin The admin to create.
     * @return The created admin.
     */
    Admin createAdmin(Admin admin);

    /**
     * Updates an existing admin.
     *
     * @param id    The ID of the admin to update.
     * @param admin The updated admin information.
     * @return The updated admin.
     */
    Admin updateAdmin(int id, Admin admin);

    /**
     * Deletes an admin by ID.
     *
     * @param id The ID of the admin to delete.
     * @return A success message indicating the admin deletion.
     */
    String deleteAdmin(int id);
    
    /**
     * Retrieves an admin by email.
     *
     * @param email The email of the admin to retrieve.
     * @return The retrieved admin.
     */
    Admin getByEmail(String email);
    
    /**
     * Retrieves all admins.
     *
     * @return A list of all admins.
     */
    List<Admin> getAll();
    
    /**
     * Modifies an admin's details.
     *
     * @param admin The modified admin.
     */
    void modify(Admin admin);

    /**
     * Adds a new admin.
     *
     * @param admin The admin to add.
     */
    void add(Admin admin);
    
    /**
	 * Authenticate customer by username and password.
	 * 
	 * @param admin details such as username and password .
	 * @return An ResponseEntity containing the string, based on admin provide
	 *         valid username, password or not.
	 */
    ResponseEntity<String> authenticateAdmin(Admin admin);
}
