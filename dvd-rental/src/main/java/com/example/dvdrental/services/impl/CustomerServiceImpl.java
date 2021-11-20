package com.example.dvdrental.services.impl;

import com.example.dvdrental.model.Customer;
import com.example.dvdrental.repository.CustomerRepository;
import com.example.dvdrental.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllItems() {
        return customerRepository.findAll();
    }

    @Override
    public void saveItem(Customer item) {
        customerRepository.save(item);
    }

    @Override
    public Customer getItemById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        customerRepository.deleteById(id);
    }
}
