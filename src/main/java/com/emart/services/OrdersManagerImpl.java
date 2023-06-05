package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Orders;
import com.emart.repository.OrdersRepository;

@Service
public class OrdersManagerImpl implements OrdersManager {
	
	@Autowired
	public OrdersRepository repository;

	/**
	  * @author  Sumukh
	  * @version 3.9.10
	  * @since   24-05-2023
	 * Add an order.
	 * 
	 * @param order The order to be added.
	 */
	@Override
	public void addOrders(Orders order) {
		repository.save(order);
	}

	/**
	 * Get all orders.
	 * 
	 * @return The list of all orders.
	 */
	@Override
	public List<Orders> getAllOrders() {
		return repository.findAll();
	}

	/**
	 * Get an order by ID.
	 * 
	 * @param order_Id The ID of the order.
	 * @return An optional containing the order, or an empty optional if not found.
	 */
	@Override
	public Optional<Orders> getOrders(int order_Id) {
		return repository.findById(order_Id);
	}

	/**
	 * Delete an order by ID.
	 * 
	 * @param order_Id The ID of the order to be deleted.
	 */
	@Override
	public void delete(int order_Id) {
		repository.deleteById(order_Id);
	}

	/**
	 * Check if an order exists by ID.
	 * 
	 * @param order_Id The ID of the order.
	 * @return True if the order exists, false otherwise.
	 */
	@Override
	public boolean exists(int order_Id) {
		return repository.existsById(order_Id);
	}
}
