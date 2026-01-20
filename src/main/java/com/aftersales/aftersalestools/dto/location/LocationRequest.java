package com.aftersales.aftersalestools.dto.location;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String type;
}
