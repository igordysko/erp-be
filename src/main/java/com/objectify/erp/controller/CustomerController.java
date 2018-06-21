package com.objectify.erp.controller;

import com.objectify.erp.domain.Customer;
import com.objectify.erp.dto.CustomerDto;
import com.objectify.erp.exception.ResourceNotFoundException;
import com.objectify.erp.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> customerDtos = customerDao
                .findAll()
                .stream()
                .map(customer -> CustomerDto.from(customer))
                .collect(Collectors.toList());
        return customerDtos;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto create(@RequestParam("name") String name) {
        Customer customer = new Customer();
        customer.setName(name);

        customer = customerDao.save(customer);
        return CustomerDto.from(customer);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto update(@PathVariable Long id,
                              @RequestParam("name") String name) {

        Optional<Customer> optionalCustomer = customerDao.findById(id);
        if(!optionalCustomer.isPresent()) {
            throw new ResourceNotFoundException("Customer does not exist. Id: " + id);
        }
        Customer customer = optionalCustomer.get();
        customer.setName(name);

        customer = customerDao.save(customer);
        return CustomerDto.from(customer);
    }

}
