package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.location.LocationRequest;
import com.aftersales.aftersalestools.dto.location.LocationResponse;
import com.aftersales.aftersalestools.entity.Location;
import com.aftersales.aftersalestools.exception.ResourceNotFoundException;
import com.aftersales.aftersalestools.repository.LocationRepository;
import com.aftersales.aftersalestools.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public LocationResponse create(LocationRequest request) {
        Location location = new Location();
        location.setCode(request.getCode());
        location.setName(request.getName());
        location.setType(request.getType());

        Location saved = locationRepository.save(location);
        return mapToResponse(saved);
    }

    @Override
    public List<LocationResponse> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public LocationResponse findById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        return mapToResponse(location);
    }

    private LocationResponse mapToResponse(Location location) {
        return new LocationResponse(
                location.getId(),
                location.getCode(),
                location.getName(),
                location.getType()
        );
    }
}

