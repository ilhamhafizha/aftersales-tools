package com.aftersales.aftersalestools.controller;

import com.aftersales.aftersalestools.dto.technician.TechnicianRequest;
import com.aftersales.aftersalestools.dto.technician.TechnicianResponse;
import com.aftersales.aftersalestools.entity.Technician;
import com.aftersales.aftersalestools.repository.TechnicianRepository;
import com.aftersales.aftersalestools.service.TechnicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
@RequiredArgsConstructor
public class TechnicianController {

    private final TechnicianService technicianService;

    @PostMapping
    public TechnicianResponse create(
            @RequestBody TechnicianRequest request) {
        return technicianService.create(request);
    }

    @GetMapping
    public List<TechnicianResponse> findAll() {
        return technicianService.findAll();
    }
}
