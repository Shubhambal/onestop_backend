package com.emart.services;

import java.util.List;
import java.util.Optional;

import com.emart.entities.CartItem;

/**
 * Service interface for managing CartItem entities.
 */
public interface CartItemManager {

    /**
     * Add a cart item.
     *
     * @param cartItem The cart item to add.
     */
    void addCartItem(CartItem cartItem);

    /**
     * Get all cart items.
     *
     * @return A list of cart items.
     */
    List<CartItem> getCartItems();

    /**
     * Delete a cart item by ID.
     *
     * @param id The ID of the cart item to delete.
     */
    void delete(int id);

    /**
     * Update a cart item.
     *
     * @param cartItem The updated cart item.
     * @param id       The ID of the cart item to update.
     */
    void update(CartItem cartItem, int id);

    /**
     * Get a cart item by ID.
     *
     * @param id The ID of the cart item to retrieve.
     * @return An optional containing the cart item, or empty if not found.
     */
    Optional<CartItem> getCartItem(int id);

    // Add more methods for managing cart items here

}
