package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.location.LocationRequest;
import com.aftersales.aftersalestools.dto.location.LocationResponse;

import java.util.List;

public interface LocationService {

    LocationResponse create(LocationRequest request);

    List<LocationResponse> findAll();

    LocationResponse findById(Long id);
}

