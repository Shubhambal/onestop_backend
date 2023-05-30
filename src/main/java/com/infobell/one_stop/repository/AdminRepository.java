package com.infobell.one_stop.repository;

import com.infobell.one_stop.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	//Admin findById(String email);

	public Admin findByemailId(@Param(value = "emailId")String emailId);

	//public Admin findByEmail(@Param(value = "emailId")String emailId);
}



