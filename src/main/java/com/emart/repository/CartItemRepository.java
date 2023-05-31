package com.emart.repository;

import com.emart.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository interface for managing CartItem entities.
 */
@Repository
@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    /**
     * Update the quantity of a cart item.
     *
     * @param quantity The new quantity.
     * @param id       The cart item ID.
     */
    @Modifying
    @Query("update CartItem c set c.quantity = :quantity where c.cart_Item_Id = :id")
    void updateQuantity(@Param("quantity") int quantity, @Param("id") int id);

    /**
     * Custom update method for cart item.
     *
     * @param quantity The new quantity.
     * @param id       The cart item ID.
     */
    //void update(int quantity, int id);
}
