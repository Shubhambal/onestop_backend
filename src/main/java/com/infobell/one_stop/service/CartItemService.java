package com.infobell.one_stop.service;

import com.infobell.one_stop.model.CartItem;

import java.util.List;

public interface CartItemService {

    /**
     * Retrieves all cart items.
     *
     * @return A list of cart items.
     */
    List<CartItem> getAllCartItems();

    /**
     * Retrieves a cart item by its ID.
     *
     * @param cartItemId The ID of the cart item.
     * @return The cart item with the given ID.
     */
    CartItem getCartItemById(int cartItemId);

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
     * @param cartItemId The ID of the cart item to update.
     * @param cartItem   The updated cart item.
     * @return The updated cart item.
     */
    CartItem updateCartItem(int cartItemId, CartItem cartItem);

    /**
     * Deletes a cart item.
     *
     * @param cartItemId The ID of the cart item to delete.
     */
    void deleteCartItem(int cartItemId);
}
