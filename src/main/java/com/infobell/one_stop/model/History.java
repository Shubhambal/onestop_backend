package com.infobell.one_stop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents a history entry in the system.
 */
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int historyId;
//
//    @Column(name = "order_id")
//    private int orderId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_price")
    private float productPrice;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    /**
     * Gets the history ID.
     *
     * @return The history ID.
     */
    public int getHistoryId() {
        return historyId;
    }

    /**
     * Sets the history ID.
     *
     * @param historyId The history ID to set.
     */
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

//    /**
//     * Gets the order ID associated with the history entry.
//     *
//     * @return The order ID.
//     */
//    public int getOrderId() {
//        return orderId;
//    }
//
//    /**
//     * Sets the order ID associated with the history entry.
//     *
//     * @param orderId The order ID to set.
//     */
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    /**
     * Gets the product name associated with the history entry.
     *
     * @return The product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name associated with the history entry.
     *
     * @param productName The product name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the product image associated with the history entry.
     *
     * @return The product image.
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * Sets the product image associated with the history entry.
     *
     * @param productImage The product image to set.
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * Gets the product price associated with the history entry.
     *
     * @return The product price.
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * Sets the product price associated with the history entry.
     *
     * @param productPrice The product price to set.
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Gets the total cost associated with the history entry.
     *
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost associated with the history entry.
     *
     * @param totalCost The total cost to set.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets the order date associated with the history entry.
     *
     * @return The order date.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date associated with the history entry.
     *
     * @param orderDate The order date to set.
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the order associated with the history entry.
     *
     * @return The order.
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the history entry.
     *
     * @param order The order to set.
     */
    public void setOrder(Orders order) {
        this.order = order;
    }
}
