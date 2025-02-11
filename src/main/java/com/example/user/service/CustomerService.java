package com.example.user.service;

import com.example.user.model.Customer;
import com.example.user.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private  final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("customer ID not Found"));
    }

    public Customer updateCustomer(Customer customerUpdate) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerUpdate.getId());
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setEmail(customerToUpdate.getEmail());
            customerToUpdate.setName(customerUpdate.getName());
            customerRepository.save(customerToUpdate);
            return customerToUpdate;
        }
        return null;

    }
    @Transactional
    public Customer deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
        return null;
    }


}
