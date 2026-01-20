package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.customer.CustomerRequest;
import com.aftersales.aftersalestools.dto.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request);
    List<CustomerResponse> findAll();
}
