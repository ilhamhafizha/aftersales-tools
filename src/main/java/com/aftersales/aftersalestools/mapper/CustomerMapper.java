package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import com.aftersales.aftersalestools.entity.Customer;

public class CustomerMapper {

    public static CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setLocationId(customer.getLocation().getId());
        response.setLocationName(customer.getLocation().getName());
        response.setCreatedAt(customer.getCreatedAt());
        return response;
    }
}
