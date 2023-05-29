package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Admin;

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
}
