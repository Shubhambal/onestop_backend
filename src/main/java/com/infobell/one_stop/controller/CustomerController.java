package com.infobell.one_stop.controller;

import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.service.CustomerService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create a new customer
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        try {
            String message = customerService.deleteCustomer(id);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
//  //checking BCrypt password
//		static private boolean checkPass1(String plainPassword, String hashedPassword) {
//			if (BCrypt.checkpw(plainPassword, hashedPassword)) {
//				System.out.println("The password matches.");
//				return true;
//			}
//			else {
//				System.out.println("The password does not match.");
//				return false;
//			}
//		}
    @PostMapping("/customerRegister")
	public void customerRegister(@RequestBody Customer customer) {
    	customerService.add(customer);
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
		
		//player table check for logged in email and password
			public Customer customerCheck(String email, String plainPassword ) {
				
				Customer customer = CustomerService.getByEmail(email);
				if (customer != null) {
					String hashedPassword=customer.getPassword();
					if(checkPass(plainPassword, hashedPassword)) {
						return customer;
					}
				}
				return null;
			}
		
		@PostMapping(value= {"/customerLogin"})
		public Object userLogin(@RequestBody Customer customer ) {
			
			String email = customer.getEmailId();
			String plainPassword=customer.getPassword();
			
			if(customerCheck(email, plainPassword)!=null) {
				return customerCheck(email, plainPassword);
			}
			else
				return null;				
		}
}
