package com.objectify.erp.dto;

import com.objectify.erp.domain.Customer;

public class CustomerDto {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public CustomerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerDto setName(String name) {
        this.name = name;
        return this;
    }

    public static CustomerDto from(Customer customer) {
        return new CustomerDto().setName(customer.getName()).setId(customer.getId());
    }
}
