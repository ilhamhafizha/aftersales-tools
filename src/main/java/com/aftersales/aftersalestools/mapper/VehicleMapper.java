package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.vehicle.VehicleResponse;
import com.aftersales.aftersalestools.entity.Vehicle;

public class VehicleMapper {

    public static VehicleResponse toResponse(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        response.setId(vehicle.getId());
        response.setPlateNumber(vehicle.getPlateNumber());
        response.setBrand(vehicle.getBrand());
        response.setModel(vehicle.getModel());

        response.setCustomerId(vehicle.getCustomer().getId());
        response.setCustomerName(vehicle.getCustomer().getName());

        response.setLocationId(vehicle.getCustomer().getLocation().getId());
        response.setLocationName(vehicle.getCustomer().getLocation().getName());

        return response;
    }
}
