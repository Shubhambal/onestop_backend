package com.emart.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_Id;
	
	@Column(name = "total_Cost")
	private Double total_Cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_Id")
	private Customer customer;
    
	/**
     * Default constructor for the Cart class.
     */
	public Cart() {
		super();
	}
	 /**
     * Parameterized constructor for the Cart class.
     *
     * @param cart_Id       The cart ID.
     * @param total_Cost    The total cost of the cart.
     * @param customer      The associated customer.
     */
	public Cart(int cart_Id, Double total_Cost, Customer customer) {
		super();
		this.cart_Id = cart_Id;
		this.total_Cost = total_Cost;
		this.customer = customer;
	}

	/**
	 * Get the cart ID.
	 *
	 * @return The cart ID.
	 */
	public int getCart_Id() {
		return cart_Id;
	}

	/**
	 * Set the cart ID.
	 *
	 * @param cart_Id The cart ID to set.
	 */
	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}

	/**
	 * Get the total cost of the cart.
	 *
	 * @return The total cost of the cart.
	 */
	public Double getTotal_Cost() {
		return total_Cost;
	}

	/**
	 * Set the total cost of the cart.
	 *
	 * @param total_Cost The total cost of the cart to set.
	 */
	public void setTotal_Cost(Double total_Cost) {
		this.total_Cost = total_Cost;
	}
	
	/**
	 * Get the customer associated with the cart.
	 *
	 * @return The customer associated with the cart.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set the customer associated with the cart.
	 *
	 * @param customer The customer to set.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
