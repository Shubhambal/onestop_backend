package com.emart.services;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Admin;
import com.emart.exception.AdminNotFoundException;
import com.emart.repository.AdminRepository;

/**
 * Implementation of the AdminService interface.
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * Get an admin by ID.
     *
     * @param id The ID of the admin to retrieve.
     * @return The admin with the specified ID.
     * @throws AdminNotFoundException if the admin is not found.
     */
    @Override
    public Admin getAdminById(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with ID: " + id));
    }

    /**
     * Create a new admin.
     *
     * @param admin The admin to create.
     * @return The created admin.
     */
    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    /**
     * Update an existing admin.
     *
     * @param id    The ID of the admin to update.
     * @param admin The updated admin.
     * @return The updated admin.
     * @throws AdminNotFoundException if the admin is not found.
     */
    @Override
    public Admin updateAdmin(int id, Admin admin) {
        Admin existingAdmin = getAdminById(id);

        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setFirstName(admin.getFirstName());
        existingAdmin.setLastName(admin.getLastName());
        existingAdmin.setEmailId(admin.getEmailId());

        return adminRepository.save(existingAdmin);
    }

    /**
     * Delete an admin by ID.
     *
     * @param id The ID of the admin to delete.
     * @return A message indicating the success of the deletion.
     * @throws AdminNotFoundException if the admin is not found.
     */
    @Override
    public String deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return "Admin with ID " + id + " deleted.";
        }
        throw new AdminNotFoundException("Admin not found with ID: " + id);
    }

    /**
     * Get all admins.
     *
     * @return A list of all admins.
     */
    @Override
    public List<Admin> getAll() {
        Iterable<Admin> admins = adminRepository.findAll();
        List<Admin> adminList = new ArrayList<>();
        admins.forEach(adminList::add);
        return adminList;
    }

    /**
     * Get an admin by email.
     *
     * @param email The email of the admin to retrieve.
     * @return The admin with the specified email.
     */
    @Override
    public Admin getByEmail(String email) {
        return adminRepository.findByemailId(email);
    }

    /**
     * Modify an admin's password.
     *
     * @param admin The admin to modify.
     */
    @Override
    public void modify(Admin admin) {
        String encPassword = hashPassword(admin.getPassword());
        admin.setPassword(encPassword);
        adminRepository.save(admin);
    }

    /**
     * Hash the provided plain text password using BCrypt.
     *
     * @param plainTextPassword The plain text password to hash.
     * @return The hashed password.
     */
    public String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /**
     * Add a new admin.
     *
     * @param admin The admin to add.
     */
    @Override
    public void add(Admin admin) {
        String encPassword = hashPassword(admin.getPassword());
        admin.setPassword(encPassword);
        adminRepository.save(admin);
    }
}
