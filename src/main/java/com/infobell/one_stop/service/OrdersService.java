package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Orders;

/**
 * Service interface for managing Orders.
 */
public interface OrdersService {

    /**
     * Retrieves an Orders object by its ID.
     *
     * @param id The ID of the Orders object to retrieve.
     * @return The retrieved Orders object.
     */
    Orders getOrdersById(int id);

    /**
     * Creates a new Orders object.
     *
     * @param orders The Orders object to create.
     * @return The created Orders object.
     */
    Orders createOrders(Orders orders);

    /**
     * Updates an existing Orders object.
     *
     * @param id     The ID of the Orders object to update.
     * @param orders The updated Orders object.
     * @return The updated Orders object.
     */
    Orders updateOrders(int id, Orders orders);

    /**
     * Deletes an Orders object by its ID.
     *
     * @param id The ID of the Orders object to delete.
     * @return A message indicating the success of the deletion.
     */
    String deleteOrders(int id);
}
