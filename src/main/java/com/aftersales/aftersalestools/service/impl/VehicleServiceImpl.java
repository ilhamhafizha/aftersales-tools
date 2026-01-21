package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.vehicle.VehicleRequest;
import com.aftersales.aftersalestools.dto.vehicle.VehicleResponse;
import com.aftersales.aftersalestools.entity.Customer;
import com.aftersales.aftersalestools.entity.Vehicle;
import com.aftersales.aftersalestools.exception.ResourceNotFoundException;
import com.aftersales.aftersalestools.mapper.VehicleMapper;
import com.aftersales.aftersalestools.repository.CustomerRepository;
import com.aftersales.aftersalestools.repository.VehicleRepository;
import com.aftersales.aftersalestools.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    @Override
    public VehicleResponse create(VehicleRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setCustomer(customer);

        return VehicleMapper.toResponse(
                vehicleRepository.save(vehicle)
        );
    }

    @Override
    public List<VehicleResponse> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleMapper::toResponse)
                .toList();
    }
}
