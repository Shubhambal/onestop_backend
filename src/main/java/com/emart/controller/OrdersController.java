package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Orders;
import com.emart.exception.OrdersNotFoundException;
import com.emart.services.OrdersManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The OrdersController class handles the API endpoints related to Orders operations.
 * 
 * Author: Sumukh
 * Version: 3.9.10
 * Date: 24-05-2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdersController {

    @Autowired
    public OrdersManager manager;

    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    /**
     * Adds a new order.
     *
     * @param orders The Orders object to add.
     */
    @PostMapping("api/addorders")
    public void addOrd(@RequestBody Orders orders) {
        logger.info("POST /api/addorders");
        logger.info("Orders: {}", orders);

        manager.addOrders(orders);
    }

    /**
     * Retrieves all orders.
     *
     * @return List of Orders objects.
     */
    @GetMapping("api/orders")
    public List<Orders> getAllOrd() {
        logger.info("GET /api/orders");

        return manager.getAllOrders();
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param order_Id The ID of the order to retrieve.
     * @return Optional containing the Orders if found, or throws OrdersNotFoundException if not found.
     */
    @GetMapping("api/orders/{order_Id}")
    public Optional<Orders> getOrd(@PathVariable int order_Id) {
        logger.info("GET /api/orders/{}", order_Id);

        Optional<Orders> order = manager.getOrders(order_Id);
        if (order.isPresent()) {
            return order;
        } else {
            throw new OrdersNotFoundException("Order not found with order_Id: " + order_Id);
        }
    }

    /**
     * Deletes an order by its ID.
     *
     * @param order_Id The ID of the order to delete.
     * @throws OrdersNotFoundException if the order is not found.
     */
    @DeleteMapping("api/orders/delete/{order_Id}")
    public void deleteOrder(@PathVariable int order_Id) {
        if (!manager.exists(order_Id)) {
            throw new OrdersNotFoundException("Order not found with order_Id: " + order_Id);
        }
        manager.delete(order_Id);
    }

}
