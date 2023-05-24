package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents the details of a product in the system.
 */
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productDetailId;

    private String productDescription;
    private String productId;

    /**
     * Gets the product detail ID.
     *
     * @return The product detail ID.
     */
    public int getProductDetailId() {
        return productDetailId;
    }

    /**
     * Sets the product detail ID.
     *
     * @param productDetailId The product detail ID to set.
     */
    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    /**
     * Gets the product description.
     *
     * @return The product description.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the product description.
     *
     * @param productDescription The product description to set.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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
}
