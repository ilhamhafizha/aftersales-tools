package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.technician.TechnicianResponse;
import com.aftersales.aftersalestools.entity.Technician;

public class TechnicianMapper {

    public static TechnicianResponse toResponse(Technician tech) {
        TechnicianResponse res = new TechnicianResponse();
        res.setId(tech.getId());
        res.setName(tech.getName());
        res.setPhone(tech.getPhone());
        res.setEmail(tech.getEmail());
        res.setActive(tech.getActive());
        return res;
    }
}
