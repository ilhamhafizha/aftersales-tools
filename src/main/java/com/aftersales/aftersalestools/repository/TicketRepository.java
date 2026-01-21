package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("""
    SELECT t FROM Ticket t
    WHERE t.slaDueAt IS NOT NULL
      AND t.slaStatus = 'ON_TIME'
      AND t.status NOT IN ('RESOLVED','CLOSED')
      AND t.slaDueAt < :now
""")
    List<Ticket> findBreachedTickets(LocalDateTime now);

}
