package com.aftersales.aftersalestools.dto.technician;

import lombok.Data;

@Data
public class TechnicianResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Boolean active;
}
