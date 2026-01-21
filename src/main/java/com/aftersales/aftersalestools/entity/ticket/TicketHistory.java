package com.aftersales.aftersalestools.entity.ticket;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_histories")
@Getter
@Setter
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status")
    private TicketStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", nullable = false)
    private TicketStatus toStatus;

    @Column(length = 500)
    private String note;

    @Column(name = "changed_by")
    private String changedBy; // sementara String (user login nanti)

    @Column(name = "changed_at")
    private LocalDateTime changedAt = LocalDateTime.now();
}
