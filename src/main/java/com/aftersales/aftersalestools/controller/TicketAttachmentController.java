package com.aftersales.aftersalestools.controller;

import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentRequest;
import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentResponse;
import com.aftersales.aftersalestools.service.TicketAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets/{ticketId}/attachments")
@RequiredArgsConstructor
public class TicketAttachmentController {

    private final TicketAttachmentService attachmentService;

    @PostMapping
    public TicketAttachmentResponse add(
            @PathVariable Long ticketId,
            @RequestBody TicketAttachmentRequest request) {
        return attachmentService.addAttachment(ticketId, request);
    }

    @GetMapping
    public List<TicketAttachmentResponse> list(
            @PathVariable Long ticketId) {
        return attachmentService.findByTicket(ticketId);
    }
}

