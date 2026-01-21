package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.entity.ticket.Ticket;
import com.aftersales.aftersalestools.entity.ticket.TicketSlaStatus;
import com.aftersales.aftersalestools.repository.TicketRepository;
import com.aftersales.aftersalestools.service.SlaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SlaServiceImpl implements SlaService {

    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public void checkAndUpdateSla() {

        List<Ticket> breachedTickets =
                ticketRepository.findBreachedTickets(LocalDateTime.now());

        for (Ticket ticket : breachedTickets) {

            ticket.setSlaStatus(TicketSlaStatus.BREACHED);

            // 🔔 AUTO REMINDER (sementara log)
            log.warn("""
                ⚠ SLA BREACHED
                Ticket ID : {}
                Vehicle   : {}
                Due At    : {}
            """,
                    ticket.getId(),
                    ticket.getVehicle().getPlateNumber(),
                    ticket.getSlaDueAt()
            );
        }

        ticketRepository.saveAll(breachedTickets);
    }
}

