package com.infobell.one_stop.repository;

import com.infobell.one_stop.model.Admin;
import com.infobell.one_stop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//Customer findByEmail(String email);
	
	public Customer findByemailId(@Param(value = "emailId")String emailId);
}
