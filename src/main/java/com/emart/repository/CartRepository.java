package com.emart.repository;

import com.emart.entities.Cart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing Cart entities.
 * 
 * @author  Shubham
 * @version 3.9.10
 * @since   24-05-2023
 */
@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {

    /**
     * Retrieve cart items with specific fields using a native SQL query.
     * 
     * @return List of Object arrays representing the cart items with the specified fields.
     */
    @Query(value = "SELECT p.p_id AS productId, " +
            "p.p_image AS productImage, " +
            "c.c_id AS customerId, " +
            "c.quantity, " +
            "c.total_cost AS totalCost, " +
            "pd.p_description AS productDescription " +
            "FROM cart c " +
            "JOIN product p ON c.p_id = p.p_id " +
            "JOIN customer cu ON c.c_id = cu.customer_id " +
            "JOIN productdetails pd ON p.p_id = pd.p_id", nativeQuery = true)
    List<Object[]> getCartItems();
}
