package com.emart.repository;

import com.emart.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing Orders entities.
  * @author  Sumukh
 * @version 3.9.10
 * @since   24-05-2023
 */
@Repository
@Transactional
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    // No additional methods to be added in this interface

}
