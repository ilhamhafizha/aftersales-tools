package com.aftersales.aftersalestools.dto.vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    private String plateNumber;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Long customerId;
}
