package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentRequest;
import com.aftersales.aftersalestools.dto.ticket.TicketAttachmentResponse;
import com.aftersales.aftersalestools.entity.ticket.Ticket;
import com.aftersales.aftersalestools.entity.ticket.TicketAttachment;
import com.aftersales.aftersalestools.exception.ResourceNotFoundException;
import com.aftersales.aftersalestools.repository.TicketAttachmentRepository;
import com.aftersales.aftersalestools.repository.TicketRepository;
import com.aftersales.aftersalestools.service.TicketAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketAttachmentServiceImpl
        implements TicketAttachmentService {

    private final TicketRepository ticketRepository;
    private final TicketAttachmentRepository attachmentRepository;

    @Override
    public TicketAttachmentResponse addAttachment(
            Long ticketId,
            TicketAttachmentRequest request) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        TicketAttachment attachment = new TicketAttachment();
        attachment.setTicket(ticket);
        attachment.setFileName(request.getFileName());
        attachment.setFileUrl(request.getFileUrl());
        attachment.setFileType(request.getFileType());

        attachmentRepository.save(attachment);

        TicketAttachmentResponse res = new TicketAttachmentResponse();
        res.setId(attachment.getId());
        res.setFileName(attachment.getFileName());
        res.setFileUrl(attachment.getFileUrl());
        res.setFileType(attachment.getFileType());
        res.setUploadedAt(attachment.getUploadedAt());

        return res;
    }

    @Override
    public List<TicketAttachmentResponse> findByTicket(Long ticketId) {
        return attachmentRepository.findByTicketId(ticketId)
                .stream()
                .map(a -> {
                    TicketAttachmentResponse res = new TicketAttachmentResponse();
                    res.setId(a.getId());
                    res.setFileName(a.getFileName());
                    res.setFileUrl(a.getFileUrl());
                    res.setFileType(a.getFileType());
                    res.setUploadedAt(a.getUploadedAt());
                    return res;
                })
                .toList();
    }
}
