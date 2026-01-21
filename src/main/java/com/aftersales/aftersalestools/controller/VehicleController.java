package com.aftersales.aftersalestools.controller;

import com.aftersales.aftersalestools.dto.vehicle.VehicleRequest;
import com.aftersales.aftersalestools.dto.vehicle.VehicleResponse;
import com.aftersales.aftersalestools.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public VehicleResponse create(@Valid @RequestBody VehicleRequest request) {
        return vehicleService.create(request);
    }

    @GetMapping
    public List<VehicleResponse> findAll() {
        return vehicleService.findAll();
    }
}
