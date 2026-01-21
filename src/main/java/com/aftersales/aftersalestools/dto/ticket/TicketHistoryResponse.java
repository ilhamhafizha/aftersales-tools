package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketHistoryResponse {

    private String fromStatus;
    private String toStatus;
    private String note;
    private String changedBy;
    private LocalDateTime changedAt;
}
