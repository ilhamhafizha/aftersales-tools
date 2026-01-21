package com.aftersales.aftersalestools.dto.ticket;

import com.aftersales.aftersalestools.entity.ticket.TicketStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketStatusUpdateRequest {

    @NotNull
    private TicketStatus toStatus;

    private String note;
}

