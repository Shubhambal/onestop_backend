package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a cart in the system.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    
    private double totalCost;
    
    private int customerId;

    /**
     * Gets the cart ID.
     *
     * @return The cart ID.
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Sets the cart ID.
     *
     * @param cartId The cart ID to set.
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * Gets the total cost of the cart.
     *
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost of the cart.
     *
     * @param totalCost The total cost to set.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets the customer ID associated with the cart.
     *
     * @return The customer ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID associated with the cart.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
