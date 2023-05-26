package com.infobell.one_stop.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Represents an order in the system.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_total")
    private double orderTotal;

    @Column(name = "order_status")
    private String orderStatus;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<History> history;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Payment> payment;

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
     * Gets the order status.
     *
     * @return The order status.
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the order status.
     *
     * @param orderStatus The order status to set.
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Gets the associated cart.
     *
     * @return The cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets the associated cart.
     *
     * @param cart The cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Gets the history associated with the order.
     *
     * @return The history.
     */
    public List<History> getHistory() {
        return history;
    }

    /**
     * Sets the history associated with the order.
     *
     * @param history The history to set.
     */
    public void setHistory(List<History> history) {
        this.history = history;
    }

    /**
     * Gets the payment associated with the order.
     *
     * @return The payment.
     */
    public List<Payment> getPayment() {
        return payment;
    }

    /**
     * Sets the payment associated with the order.
     *
     * @param payment The payment to set.
     */
    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}
