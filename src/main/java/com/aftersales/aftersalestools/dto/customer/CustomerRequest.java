package com.aftersales.aftersalestools.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long locationId;
}