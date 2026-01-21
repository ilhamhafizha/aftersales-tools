package com.aftersales.aftersalestools.dto.vehicle;

import lombok.Data;

@Data
public class VehicleResponse {

    private Long id;
    private String plateNumber;
    private String brand;
    private String model;

    private Long customerId;
    private String customerName;

    private Long locationId;
    private String locationName;
}
