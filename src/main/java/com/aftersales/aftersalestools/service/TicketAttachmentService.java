package com.aftersales.aftersalestools.service;

import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentRequest;
import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentResponse;

import java.util.List;

public interface TicketAttachmentService {

    TicketAttachmentResponse addAttachment(
            Long ticketId,
            TicketAttachmentRequest request
    );

    List<TicketAttachmentResponse> findByTicket(Long ticketId);
}
