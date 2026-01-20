package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.customer.CustomerRequest;
import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    Page<CustomerResponse> findAll(Pageable pageable);
}
