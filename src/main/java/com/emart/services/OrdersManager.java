package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.emart.entities.Orders;

public interface OrdersManager {
	
	/**
	 *  * @author  Sumukh
	 * @version 3.9.10
	 * @since   24-05-2023
	 * Add an order.
	 * 
	 * @param order The order to be added.
	 */
	void addOrders(Orders order);
	
	/**
	 * Get all orders.
	 * 
	 * @return The list of all orders.
	 */
	List<Orders> getAllOrders();
	
	/**
	 * Get an order by ID.
	 * 
	 * @param order_Id The ID of the order.
	 * @return An optional containing the order, or an empty optional if not found.
	 */
	Optional<Orders> getOrders(int order_Id);
	
	/**
	 * Delete an order by ID.
	 * 
	 * @param order_Id The ID of the order to be deleted.
	 */
	void delete(int order_Id);
	
	/**
	 * Check if an order exists by ID.
	 * 
	 * @param order_Id The ID of the order.
	 * @return True if the order exists, false otherwise.
	 */
	boolean exists(int order_Id);
}
