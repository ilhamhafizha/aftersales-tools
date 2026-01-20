package com.aftersales.aftersalestools.dto.customer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerResponse {

    private Long id;
    private String name;

    private Long locationId;
    private String locationName;

    private LocalDateTime createdAt;
}
