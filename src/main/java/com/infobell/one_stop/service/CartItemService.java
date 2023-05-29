package com.infobell.one_stop.service;

import com.infobell.one_stop.model.CartItem;

public interface CartItemService {
    
    /**
     * Retrieves a cart item by its ID.
     *
     * @param id The ID of the cart item to retrieve.
     * @return The cart item with the specified ID.
     */
    CartItem getCartItemById(int id);

    /**
     * Creates a new cart item.
     *
     * @param cartItem The cart item to create.
     * @return The created cart item.
     */
    CartItem createCartItem(CartItem cartItem);

    /**
     * Updates an existing cart item.
     *
     * @param id       The ID of the cart item to update.
     * @param cartItem The updated cart item data.
     * @return The updated cart item.
     */
    CartItem updateCartItem(int id, CartItem cartItem);

    /**
     * Deletes a cart item by its ID.
     *
     * @param id The ID of the cart item to delete.
     * @return A success message indicating the deletion.
     */
    String deleteCartItem(int id);
}
