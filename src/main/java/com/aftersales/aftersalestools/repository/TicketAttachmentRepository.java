package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.ticket.TicketAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketAttachmentRepository
        extends JpaRepository<TicketAttachment, Long> {

    List<TicketAttachment> findByTicketId(Long ticketId);
}
