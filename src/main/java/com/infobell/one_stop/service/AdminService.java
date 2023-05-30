package com.infobell.one_stop.service;

import java.util.List;

import com.infobell.one_stop.model.Admin;
import com.infobell.one_stop.model.Customer;

public interface AdminService {
    /**
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
    
    
    Admin getByEmail(String email);
    
    List<Admin> getAll();
    
    void modify(Admin admin);

    void add(Admin admin);
	
}
