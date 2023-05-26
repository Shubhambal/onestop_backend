package com.infobell.one_stop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(200).body(customerService.registerCustomer(customer));
	}

	@GetMapping("/getById/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable Integer customerId) {
		return ResponseEntity.status(200).body(customerService.getCustomerById(customerId));
	}

	@GetMapping("/getAll")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable Integer customerId) {
		return ResponseEntity.status(200).body(customerService.deleteCustomer(customerId));
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer) {
		return ResponseEntity.status(200).body(customerService.updateCustomer(customer));
	}

}
