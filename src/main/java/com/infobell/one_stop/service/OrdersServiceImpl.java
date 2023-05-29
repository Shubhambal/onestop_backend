package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Orders;
import com.infobell.one_stop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders getOrdersById(int id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orders", "id", id));
    }

    @Override
    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders updateOrders(int id, Orders orders) {
        if (!ordersRepository.existsById(id)) {
            throw new ResourceNotFoundException("Orders", "id", id);
        }
        orders.setOrderId(id);
        return ordersRepository.save(orders);
    }

    @Override
    public String deleteOrders(int id) {
        if (!ordersRepository.existsById(id)) {
            throw new ResourceNotFoundException("Orders", "id", id);
        }
        ordersRepository.deleteById(id);
        return "Orders with ID " + id + " has been deleted.";
    }
}
