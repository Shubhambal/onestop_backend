package com.infobell.one_stop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

/**
 * Represents a cart in the system.
 */
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;
    
    @Column(name = "total_cost")
    private double totalCost;
     
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItems;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders order;

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
     * Gets the customer associated with the cart.
     *
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the cart.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the cart items in the cart.
     *
     * @return The cart items.
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Sets the cart items in the cart.
     *
     * @param cartItems The cart items to set.
     */
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * Gets the order associated with the cart.
     *
     * @return The order.
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the cart.
     *
     * @param order The order to set.
     */
    public void setOrder(Orders order) {
        this.order = order;
    }
}
