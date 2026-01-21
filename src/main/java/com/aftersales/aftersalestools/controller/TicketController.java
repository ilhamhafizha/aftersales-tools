package com.aftersales.aftersalestools.controller;


import com.aftersales.aftersalestools.dto.ticket.*;
import com.aftersales.aftersalestools.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public TicketResponse create(@Valid @RequestBody TicketRequest request) {
        return ticketService.create(request);
    }

    @GetMapping
    public List<TicketResponse> findAll() {
        return ticketService.findAll();
    }

    @PatchMapping("/{id}/status")
    public TicketResponse updateStatus(
            @PathVariable Long id,
            @RequestBody @Valid TicketStatusUpdateRequest request
    ) {
        return ticketService.updateStatus(id, request);
    }

    @GetMapping("/{id}")
    public TicketDetailResponse findDetail(@PathVariable Long id) {
        return ticketService.findDetail(id);
    }

    @PatchMapping("/{ticketId}/assign")
    public TicketResponse assign(
            @PathVariable Long ticketId,
            @RequestBody TicketAssignRequest request) {
        return ticketService.assignTechnician(ticketId, request);
    }


}
