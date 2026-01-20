package com.aftersales.aftersalestools.controller;

import com.aftersales.aftersalestools.dto.customer.CustomerRequest;
import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import com.aftersales.aftersalestools.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse create(@Valid @RequestBody CustomerRequest request) {
        return customerService.create(request);
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }
}
