package com.infobell.one_stop.service;

import org.springframework.http.ResponseEntity;
import com.infobell.one_stop.model.Customer;

public interface LoginService {

	public ResponseEntity<String> authenticateCustomer(Customer customer);

}
