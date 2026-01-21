package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketAssignRequest {
    private Long technicianId;
    private LocalDateTime slaDueAt;
}
