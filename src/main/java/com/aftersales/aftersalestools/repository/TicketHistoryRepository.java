package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.ticket.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {
    List<TicketHistory> findByTicketIdOrderByChangedAtAsc(Long ticketId);
}
