package com.emart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartitem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_Item_Id;
    
    private int quantity;
    private double prime_CustomerPrice;
    
    private int p_Id;
    
    private int cart_Id;
    
    /**
     * Default constructor for the CartItem class.
     */
    public CartItem() {
        super();
    }
    
    /**
     * Parameterized constructor for the CartItem class.
     *
     * @param cart_Item_Id          The cart item ID.
     * @param quantity              The quantity of the cart item.
     * @param prime_CustomerPrice   The price for prime customers.
     * @param p_Id                  The product ID.
     * @param cart_Id               The cart ID.
     */
    public CartItem(int cart_Item_Id, int quantity, double prime_CustomerPrice, int p_Id, int cart_Id) {
        super();
        this.cart_Item_Id = cart_Item_Id;
        this.quantity = quantity;
        this.prime_CustomerPrice = prime_CustomerPrice;
        this.p_Id = p_Id;
        this.cart_Id = cart_Id;
    }
    
    /**
     * Get the product ID associated with the cart item.
     *
     * @return The product ID.
     */
    public int getP_Id() {
        return p_Id;
    }
    
    /**
     * Set the product ID associated with the cart item.
     *
     * @param p_Id The product ID to set.
     */
    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }
    
    /**
     * Get the cart item ID.
     *
     * @return The cart item ID.
     */
    public int getCart_Item_Id() {
        return cart_Item_Id;
    }
    
    /**
     * Set the cart item ID.
     *
     * @param cart_Item_Id The cart item ID to set.
     */
    public void setCart_Item_Id(int cart_Item_Id) {
        this.cart_Item_Id = cart_Item_Id;
    }
    
    /**
     * Get the quantity of the cart item.
     *
     * @return The quantity of the cart item.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Set the quantity of the cart item.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Get the price of the cart item for prime customers.
     *
     * @return The price of the cart item for prime customers.
     */
    public double getPrime_CustomerPrice() {
        return prime_CustomerPrice;
    }
    
    /**
     * Set the price of the cart item for prime customers.
     *
     * @param prime_CustomerPrice The price of the cart item for prime customers to set.
     */
    public void setPrime_CustomerPrice(double prime_CustomerPrice) {
        this.prime_CustomerPrice = prime_CustomerPrice;
    }
    
    /**
     * Get the cart ID associated with the cart item.
     *
     * @return The cart ID.
     */
    public int getCart_Id() {
        return cart_Id;
    }
    
    /**
     * Set the cart ID associated with the cart item.
     *
     * @param cart_Id The cart ID to set.
     */
    public void setCart_Id(int cart_Id) {
        this.cart_Id = cart_Id;
    }
    
    @Override
    public String toString() {
        return "CartItem [cart_Item_Id=" + cart_Item_Id + ", quantity=" + quantity + ", product=" + p_Id + "]";
    }
}
