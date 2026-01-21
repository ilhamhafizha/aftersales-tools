package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.technician.TechnicianRequest;
import com.aftersales.aftersalestools.dto.technician.TechnicianResponse;
import com.aftersales.aftersalestools.entity.Technician;
import com.aftersales.aftersalestools.mapper.TechnicianMapper;
import com.aftersales.aftersalestools.repository.TechnicianRepository;
import com.aftersales.aftersalestools.service.TechnicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService {

    private final TechnicianRepository technicianRepository;

    @Override
    public TechnicianResponse create(TechnicianRequest request) {

        Technician tech = new Technician();
        tech.setName(request.getName());
        tech.setPhone(request.getPhone());
        tech.setEmail(request.getEmail());
        tech.setActive(request.getActive());

        Technician saved = technicianRepository.save(tech);

        return TechnicianMapper.toResponse(saved);
    }

    @Override
    public List<TechnicianResponse> findAll() {
        return technicianRepository.findAll()
                .stream()
                .map(TechnicianMapper::toResponse)
                .toList();
    }
}

