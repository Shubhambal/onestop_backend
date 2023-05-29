package com.infobell.one_stop.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.CustomerRepository;
import com.infobell.one_stop.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public ResponseEntity<String> authenticateCustomer(Customer customer) {

		Optional<Customer> opCustomer = Optional.ofNullable(customerRepository.findByEmailId(customer.getEmailId()));
		Customer dbCustomer = opCustomer.get();

		if (opCustomer.isPresent()) {
			if (bCryptPasswordEncoder.matches(customer.getPassword(), dbCustomer.getPassword()))
				return ResponseEntity.ok("Successfully Logged In.");
			else
				return ResponseEntity.ok("Wrong Password. Please try again !!");
		}

		return ResponseEntity.ok("Customer is not registered yet.");
	}

}
