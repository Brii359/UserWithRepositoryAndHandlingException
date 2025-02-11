package com.example.user.controller;

import com.example.user.exception.ApiRequestException;
import com.example.user.model.Customer;
import com.example.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();

    }

    @GetMapping(path = "{customerId}")
    Customer getCustomerById(@PathVariable("customerId")Long id) {
       return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId")Long id) {
        throw new ApiRequestException("ApiRequestException for Customer " + id);
    }

    @DeleteMapping
    public Customer deleteCustomerById(Long id) {
        return customerService.deleteCustomerById(id);
    }


    @PostMapping
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST.....");
        System.out.println(customer);
    }

    @PutMapping
     Customer updateCustomer(@RequestBody Customer customer) {
      customerService.updateCustomer(customer);
      return customer;
    }







}
