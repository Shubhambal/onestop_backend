package com.emart.entities;

import java.time.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents the orders in the system.
 * @author  Sumukh
 * @version 3.9.10
 * @since   24-05-2023
 */
@Entity
@Table(name = "Orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_Id;
    
    @Column(name = "order_Date")
    private LocalDate order_Date;
    
    @Column(name = "order_Total")
    private Double order_Total;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_Id_fk")
    private Cart cart;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id")
    private Customer customer;
    
    public Orders() {
        super();
    }
    
   
    public Orders(int order_Id, LocalDate order_Date, Double order_Total, Cart cart, Customer customer) {
		super();
		this.order_Id = order_Id;
		this.order_Date = order_Date;
		this.order_Total = order_Total;
		this.cart = cart;
		this.customer = customer;
	}


	/**
     * Get the order ID.
     *
     * @return The order ID.
     */
    public int getOrder_Id() {
        return order_Id;
    }
    
    /**
     * Set the order ID.
     *
     * @param order_Id The order ID to set.
     */
    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }
    
    /**
     * Get the order date.
     *
     * @return The order date.
     */
    public LocalDate getOrder_Date() {
        return order_Date;
    }
    
    /**
     * Set the order date.
     *
     * @param order_Date The order date to set.
     */
    public void setOrder_Date(LocalDate order_Date) {
        this.order_Date = order_Date;
    }
    
    /**
     * Get the order total.
     *
     * @return The order total.
     */
    public Double getOrder_Total() {
        return order_Total;
    }
    
    /**
     * Set the order total.
     *
     * @param order_Total The order total to set.
     */
    public void setOrder_Total(Double order_Total) {
        this.order_Total = order_Total;
    }
    
    /**
     * Get the associated cart.
     *
     * @return The cart.
     */
    public Cart getCart() {
        return cart;
    }
    
    /**
     * Set the associated cart.
     *
     * @param cart The cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Orders [order_Id=" + order_Id + ", order_Date=" + order_Date + ", order_Total=" + order_Total
				+ ", cart=" + cart + ", customer=" + customer + "]";
	}
    
   
}
