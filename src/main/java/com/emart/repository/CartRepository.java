package com.emart.repository;

import com.emart.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing Cart entities.
 */
@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {

    // No additional methods to be added in this interface
}
