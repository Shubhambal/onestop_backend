package com.infobell.one_stop.controller;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Admin;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.service.AdminService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Get admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Create a new admin
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }

    // Update an existing admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Delete an admin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int id) {
        try {
            String result = adminService.deleteAdmin(id);
            return ResponseEntity.ok(result);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    
    @PostMapping("/adminRegister")
	public void adminRegister(@RequestBody Admin admin) {
    	adminService.add(admin);
	}
    
  //checking BCrypt password
  		static private boolean checkPass(String plainPassword, String hashedPassword) {
  			if (BCrypt.checkpw(plainPassword, hashedPassword)) {
  				System.out.println("The password matches.");
  				return true;
  			}
  			else {
  				System.out.println("The password does not match.");
  				return false;
  			}
  		}
  		
  		
  		
  	//admin table check for logged in email and password
		public Admin adminCheck(String email, String plainPassword ) {
			
			Admin admin = adminService.getByEmail(email);
			if (admin != null) {
				String hashedPassword=admin.getPassword();
				if(checkPass(plainPassword, hashedPassword)) {
					return admin;
				}
			}
			return null;
		}
	
	@PostMapping(value= {"/adminLogin"})
	public Object adminLogin(@RequestBody Admin admin ) {
		
		String email = admin.getEmailId();
		String plainPassword=admin.getPassword();
		
		if(adminCheck(email, plainPassword)!=null) {
			return adminCheck(email, plainPassword);
		}
		else
			return null;				
	}
	
	
	
	
	@PostMapping("/checkEmail")
	public boolean checkEmail(@RequestBody Admin admin) {
		String email = admin.getEmailId();
		if(adminService.getByEmail(email)!=null) {
			return true;
		}
//		else if(playerService.getByEmail(email)!=null) {
//			return true;
//		}
//		else if(teamService.getByEmail(email)!=null) {
//			return true;
//		}
		return false;
	}
}
