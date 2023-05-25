package com.infobell.one_stop.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents an order in the system.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date orderDate;
    private double orderTotal;
    private int cartId;
    private String orderStatus;
    public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
     * Gets the order ID.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     *
     * @param orderId The order ID to set.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the order date.
     *
     * @return The order date.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the total amount of the order.
     *
     * @return The order total.
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the total amount of the order.
     *
     * @param orderTotal The order total to set.
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * Gets the cart ID associated with the order.
     *
     * @return The cart ID.
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Sets the cart ID associated with the order.
     *
     * @param cartId The cart ID to set.
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
