package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents an item in a cart.
 */
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
    
    private int quantity;

    // Define the many-to-one relationship with Product
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    // Define the many-to-one relationship with Cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Constructors
    
    public CartItem() {
        // Default constructor
    }

    // Getters and Setters
    
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

    /**
     * Gets the product associated with the cart item.
     *
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product associated with the cart item.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the cart associated with the cart item.
     *
     * @return The cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets the cart associated with the cart item.
     *
     * @param cart The cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
