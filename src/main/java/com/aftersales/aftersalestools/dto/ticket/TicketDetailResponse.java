package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

import java.util.List;

@Data
public class TicketDetailResponse {

    private TicketResponse ticket;
    private List<TicketHistoryResponse> histories;
}
