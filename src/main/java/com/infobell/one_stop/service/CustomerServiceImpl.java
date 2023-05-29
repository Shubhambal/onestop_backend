package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "ID", id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer", "ID", id);
        }
        customer.setCustomerId(id);
        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer", "ID", id);
        }
        customerRepository.deleteById(id);
        return "Customer with ID " + id + " has been deleted.";
    }
}
