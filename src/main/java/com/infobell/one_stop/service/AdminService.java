package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin getAdminById(int id);
    Admin createAdmin(Admin admin);
    Admin updateAdmin(int id, Admin admin);
    boolean deleteAdmin(int id);
}
