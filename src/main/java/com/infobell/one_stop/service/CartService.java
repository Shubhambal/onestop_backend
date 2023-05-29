package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Cart;

public interface CartService {
    
    /**
     * Retrieves a cart by its ID.
     *
     * @param id The ID of the cart.
     * @return The retrieved cart.
     */
    Cart getCartById(int id);

    /**
     * Creates a new cart.
     *
     * @param cart The cart to create.
     * @return The created cart.
     */
    Cart createCart(Cart cart);

    /**
     * Updates an existing cart.
     *
     * @param id   The ID of the cart to update.
     * @param cart The updated cart data.
     * @return The updated cart.
     */
    Cart updateCart(int id, Cart cart);

    /**
     * Deletes a cart by its ID.
     *
     * @param id The ID of the cart to delete.
     * @return A message indicating the deletion status.
     */
    String deleteCart(int id);
}
