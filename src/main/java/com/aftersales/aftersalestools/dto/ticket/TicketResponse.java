package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TicketResponse {

    private Long id;

    // Vehicle
    private Long vehicleId;
    private String plateNumber;
    private String brand;
    private String model;

    // Customer & Location
    private String customerName;
    private String locationName;

    // Ticket
    private String category;
    private String status;
    private String description;

    private LocalDate complaintDate;
    private LocalDate resolvedDate;
    private Integer odometer;

    private LocalDateTime createdAt;

    // Technician
    private Long technicianId;
    private String technicianName;

    // SLA
    private LocalDateTime slaStartAt;
    private LocalDateTime slaDueAt;
    private LocalDateTime slaResolvedAt;

}
