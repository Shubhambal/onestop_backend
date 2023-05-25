package com.infobell.one_stop.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.CustomerRepository;
import com.infobell.one_stop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> registerCustomer(Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Customer registered successfully.");
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(Integer customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			return ResponseEntity.ok(customer);
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	@Override
	public ResponseEntity<?> deleteCustomer(Integer customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return ResponseEntity.ok().body("Customer deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }
	
	@Override
	public ResponseEntity<?> updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerId())) {
            Customer updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }

}
