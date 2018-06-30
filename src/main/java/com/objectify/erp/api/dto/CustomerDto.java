package com.objectify.erp.api.dto;

import com.objectify.erp.domain.model.Customer;
import org.immutables.value.Value;

@Value.Immutable
public abstract class CustomerDto {

    public abstract Long getId();

    public abstract String getName();

    public static CustomerDto from(Customer customer) {
        if (customer == null) {
            return null;
        }
        return ImmutableCustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }
}
