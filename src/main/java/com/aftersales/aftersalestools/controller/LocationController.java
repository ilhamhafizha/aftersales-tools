package com.aftersales.aftersalestools.controller;
import com.aftersales.aftersalestools.dto.location.LocationRequest;
import com.aftersales.aftersalestools.dto.location.LocationResponse;
import com.aftersales.aftersalestools.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public LocationResponse create(@Valid @RequestBody LocationRequest request) {
        return locationService.create(request);
    }

    @GetMapping
    public List<LocationResponse> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public LocationResponse findById(@PathVariable Long id) {
        return locationService.findById(id);
    }
}
