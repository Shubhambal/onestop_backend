package com.infobell.one_stop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Represents the details of a product in the system.
 */
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private int productDetailId;
    
    @Column(name = "discount")
    private int discount;
    
    @Column(name = "specification")
    private String specification;
    
    // Establishes a one-to-one relationship with the Product entity
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    /**
     * Gets the discount of the product.
     *
     * @return The discount.
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets the discount of the product.
     *
     * @param discount The discount to set.
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Gets the specification of the product.
     *
     * @return The specification.
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * Sets the specification of the product.
     *
     * @param specification The specification to set.
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * Gets the associated product.
     *
     * @return The associated product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the associated product.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

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
}
