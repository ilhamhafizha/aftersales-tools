package com.aftersales.aftersalestools.controller;

import com.aftersales.aftersalestools.common.PageResponse;
import com.aftersales.aftersalestools.dto.customer.CustomerRequest;
import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import com.aftersales.aftersalestools.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
    public PageResponse<CustomerResponse> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CustomerResponse> result =
                customerService.findAll(PageRequest.of(page, size));

        return new PageResponse<>(
                result.getContent(),
                new PageResponse.Pagination(
                        result.getNumber(),
                        result.getSize(),
                        result.getTotalElements(),
                        result.getTotalPages()
                )
        );
    }


}
