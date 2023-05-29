package com.infobell.one_stop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.service.LoginService;

@RestController
@RequestMapping("/customer")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateCustomer(@RequestBody Customer customer){
		return ResponseEntity.status(200).body(loginService.authenticateCustomer(customer));
	}
	
}
