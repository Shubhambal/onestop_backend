package com.emart.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.CartItem;
import com.emart.repository.CartItemRepository;

/**
 * Implementation of the CartItemManager interface.
 */
@Service
public class CartItemManagerImpl implements CartItemManager {

    @Autowired
    CartItemRepository repository;

    /**
     * Add a cart item.
     *
     * @param cartItem The cart item to add.
     */
    @Override
    public void addCartItem(CartItem cartItem) {
        repository.save(cartItem);
    }

    /**
     * Get all cart items.
     *
     * @return A list of cart items.
     */
    @Override
    public List<CartItem> getCartItems() {
        return repository.findAll();
    }

    /**
     * Delete a cart item by ID.
     *
     * @param id The ID of the cart item to delete.
     */
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    /**
     * Update the quantity of a cart item.
     *
     * @param cartItem The updated cart item.
     * @param id       The ID of the cart item to update.
     */
    @Override
    public void update(CartItem cartItem, int id) {
        repository.updateQuantity(cartItem.getQuantity(), id);
    }

    /**
     * Get a cart item by ID.
     *
     * @param id The ID of the cart item to retrieve.
     * @return An Optional containing the cart item, or an empty Optional if not found.
     */
    @Override
    public Optional<CartItem> getCartItem(int id) {
        return repository.findById(id);
    }
}
