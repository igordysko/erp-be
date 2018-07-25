package com.objectify.erp.application.service;

import com.objectify.erp.domain.dao.CustomerDao;
import com.objectify.erp.domain.exception.ResourceNotFoundException;
import com.objectify.erp.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer findCustomerById(Long customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer id is null");
        }

        Optional<Customer> customerOpt = customerDao.findById(customerId);
        if (!customerOpt.isPresent()) {
            throw new ResourceNotFoundException("Customer not found. Id: " + customerId);
        }

        return customerOpt.get();
    }

}
