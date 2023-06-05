package com.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emart.entities.Payment;

/**
 * Repository interface for managing Payment entities.
 * @author  Sumukh
 * @version 3.9.10
 * @since   24-05-2023
 */
@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Add custom methods or queries for Payment repository here
    
}
