package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Customer;
import com.infobell.one_stop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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

    @Override
	public void add(Customer customer) {
		String encPassword = hashPassword(customer.getPassword());
		customer.setPassword(encPassword);
		customerRepository.save(customer);
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public void modify(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void removeById(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getById(int id) {
		Optional<Customer> opt = customerRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Customer> getAll() {
		Iterable<Customer> itr = customerRepository.findAll();
		List<Customer> lst = new ArrayList<Customer>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}

	
	public Customer getByEmail(String email) {
		Customer customer = customerRepository.findByemailId(email);
		return customer;
	}
}
