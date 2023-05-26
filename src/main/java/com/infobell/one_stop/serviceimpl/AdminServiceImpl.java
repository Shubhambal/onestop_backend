package com.infobell.one_stop.serviceimpl;

import com.infobell.one_stop.model.Admin;
import com.infobell.one_stop.repository.AdminRepository;
import com.infobell.one_stop.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        return adminOptional.orElse(null);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(int id, Admin admin) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            Admin existingAdmin = adminOptional.get();
            existingAdmin.setUsername(admin.getUsername());
            existingAdmin.setPassword(admin.getPassword());
            existingAdmin.setFirstName(admin.getFirstName());
            existingAdmin.setLastName(admin.getLastName());
            existingAdmin.setEmailId(admin.getEmailId());
            return adminRepository.save(existingAdmin);
            } else {
            return null;
        }
    }

    @Override
    public boolean deleteAdmin(int id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            adminRepository.deleteById(id);
            return true;
            } else {
            return false;
            }
        }
}
