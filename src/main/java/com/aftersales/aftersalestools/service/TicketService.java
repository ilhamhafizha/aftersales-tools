package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.ticket.*;

import java.util.List;

public interface TicketService {

    TicketResponse create(TicketRequest request);

    List<TicketResponse> findAll();

    TicketResponse updateStatus(Long ticketId, TicketStatusUpdateRequest request);

    TicketDetailResponse findDetail(Long ticketId);

    TicketResponse assignTechnician(
            Long ticketId,
            TicketAssignRequest request
    );



}

