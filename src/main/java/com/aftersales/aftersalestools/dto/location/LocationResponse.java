package com.aftersales.aftersalestools.dto.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

    private Long id;
    private String code;
    private String name;
    private String type;
}
