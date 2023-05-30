package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Admin;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin getAdminById(int id) {
        // Retrieve admin by ID from the repository
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", String.valueOf(id)));
    }

    @Override
    public Admin createAdmin(Admin admin) {
        // Save new admin to the repository
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(int id, Admin admin) {
        // Retrieve existing admin by ID from the repository
        Admin existingAdmin = getAdminById(id);
        
        // Update the properties of the existing admin
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setFirstName(admin.getFirstName());
        existingAdmin.setLastName(admin.getLastName());
        existingAdmin.setEmailId(admin.getEmailId());

        // Save the updated admin to the repository
        return adminRepository.save(existingAdmin);
    }

    @Override
    public String deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            // Delete admin by ID from the repository
            adminRepository.deleteById(id);
            return "Admin with ID " + id + " deleted.";
        }
        throw new ResourceNotFoundException("Admin", "id", String.valueOf(id));
    }
    
    
    
    
//    @Autowired
//	private AdminDao adminDao;
	
	@Override
	public List<Admin> getAll() {
		Iterable<Admin> itr = adminRepository.findAll();
		List<Admin> lst = new ArrayList<Admin>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}
	
	@Override
	public Admin getByEmail(String email) {
		Admin admin = adminRepository.findByemailId(email);
		return admin;
	}
	
	@Override
	public void modify(Admin admin) {
		String encPassword = hashPassword(admin.getPassword());
		admin.setPassword(encPassword);
		adminRepository.save(admin);
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public void add(Admin admin) {
		String encPassword = hashPassword(admin.getPassword());
		admin.setPassword(encPassword);
		adminRepository.save(admin);
	}
	
	
}
