package com.aftersales.aftersalestools.dto.ticket;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketRequest {

    @NotNull
    private Long vehicleId;

    private String category;
    private String description;

    private String damageCategory;
    private String damagedPart;

    private LocalDate complaintDate;
    private Integer odometer;

    private String picName;
    private String picPhone;
}
