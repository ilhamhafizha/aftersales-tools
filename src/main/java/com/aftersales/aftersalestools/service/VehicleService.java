package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.vehicle.VehicleRequest;
import com.aftersales.aftersalestools.dto.vehicle.VehicleResponse;

import java.util.List;

public interface VehicleService {
    VehicleResponse create(VehicleRequest request);
    List<VehicleResponse> findAll();
}
