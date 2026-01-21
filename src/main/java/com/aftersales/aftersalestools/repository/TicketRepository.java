package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
