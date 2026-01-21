package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.technician.TechnicianRequest;
import com.aftersales.aftersalestools.dto.technician.TechnicianResponse;

import java.util.List;

public interface TechnicianService {
    TechnicianResponse create(TechnicianRequest request);
    List<TechnicianResponse> findAll();
}
