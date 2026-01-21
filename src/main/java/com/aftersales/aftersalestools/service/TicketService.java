package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.ticket.TicketDetailResponse;
import com.aftersales.aftersalestools.dto.ticket.TicketRequest;
import com.aftersales.aftersalestools.dto.ticket.TicketResponse;
import com.aftersales.aftersalestools.dto.ticket.TicketStatusUpdateRequest;

import java.util.List;

public interface TicketService {

    TicketResponse create(TicketRequest request);

    List<TicketResponse> findAll();

    TicketResponse updateStatus(Long ticketId, TicketStatusUpdateRequest request);

    TicketDetailResponse findDetail(Long ticketId);

}

