package com.infobell.one_stop.model;

import java.util.List;
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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents a product in the system.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private float productPrice;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private List<CartItem> cartItems;

//    @OneToOne
//    @JoinColumn(name = "product_id")
    @JsonManagedReference
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductDetails productDetails;

    /**
     * Gets the product ID.
     *
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets the product ID.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets the item ID of the product.
     *
     * @return The item ID.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the item ID of the product.
     *
     * @param itemId The item ID to set.
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
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
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     *
     * @param productName The product name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the price of the product.
     *
     * @return The product price.
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * Sets the price of the product.
     *
     * @param productPrice The product price to set.
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Gets the category of the product.
     *
     * @return The category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category The category to set.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets the list of cart items associated with the product.
     *
     * @return The list of cart items.
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Sets the list of cart items associated with the product.
     *
     * @param cartItems The list of cart items to set.
     */
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * Gets the product details.
     *
     * @return The product details.
     */
    public ProductDetails getProductDetails() {
        return productDetails;
    }

    /**
     * Sets the product details.
     *
     * @param productDetails The product details to set.
     */
    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}
