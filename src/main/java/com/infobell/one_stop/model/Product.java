package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a product in the system.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masterId;

    private String productId;
    private String productImage;
    private String name;
    private float price;
    private int categoryId;

    /**
     * Gets the master ID of the product.
     *
     * @return The master ID.
     */
    public int getMasterId() {
        return masterId;
    }

    /**
     * Sets the master ID of the product.
     *
     * @param masterId The master ID to set.
     */
    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    /**
     * Gets the product ID.
     *
     * @return The product ID.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the product ID.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the product image.
     *
     * @return The product image.
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * Sets the product image.
     *
     * @param productImage The product image to set.
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The product name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The product price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The product price to set.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the category ID of the product.
     *
     * @return The category ID.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category ID of the product.
     *
     * @param categoryId The category ID to set.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
