package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import com.aftersales.aftersalestools.entity.Customer;

public class CustomerMapper {

    private CustomerMapper() {}

    public static CustomerResponse toResponse(Customer customer) {
        CustomerResponse dto = new CustomerResponse();
        dto.setId(customer.getId());
        dto.setName(customer.getName());

        dto.setLocationId(customer.getLocation().getId());
        dto.setLocationName(customer.getLocation().getName());

        dto.setCreatedAt(customer.getCreatedAt());
        return dto;
    }
}
