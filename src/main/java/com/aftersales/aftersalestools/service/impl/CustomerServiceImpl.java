package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.customer.CustomerRequest;
import com.aftersales.aftersalestools.dto.customer.CustomerResponse;
import com.aftersales.aftersalestools.entity.Customer;
import com.aftersales.aftersalestools.entity.Location;
import com.aftersales.aftersalestools.exception.ResourceNotFoundException;
import com.aftersales.aftersalestools.mapper.CustomerMapper;
import com.aftersales.aftersalestools.repository.CustomerRepository;
import com.aftersales.aftersalestools.repository.LocationRepository;
import com.aftersales.aftersalestools.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final LocationRepository locationRepository;

    @Override
    public CustomerResponse create(CustomerRequest request) {
        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setLocation(location);

        return CustomerMapper.toResponse(
                customerRepository.save(customer)
        );
    }

    @Override
    public Page<CustomerResponse> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(CustomerMapper::toResponse);
    }


}
