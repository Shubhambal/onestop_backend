package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Customer;

public interface CustomerService {
    Customer getCustomerById(int id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(int id, Customer customer);

    String deleteCustomer(int id);
}
