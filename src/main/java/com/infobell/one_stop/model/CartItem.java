package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents an item in a cart.
 */
@Entity
public class CartItem { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
    
    private int cartId;
    
    private int productId; 
    
    private int quantity;

    /**
     * Gets the cart item ID.
     *
     * @return The cart item ID.
     */
    public int getCartItemId() {
        return cartItemId;
    }

    /**
     * Sets the cart item ID.
     *
     * @param cartItemId The cart item ID to set.
     */
    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    /**
     * Gets the cart ID associated with the cart item.
     *
     * @return The cart ID.
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Sets the cart ID associated with the cart item.
     *
     * @param cartId The cart ID to set.
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * Gets the product ID associated with the cart item.
     *
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the product ID associated with the cart item.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the cart item.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the cart item.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
