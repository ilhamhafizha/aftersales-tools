package com.aftersales.aftersalestools.service.impl;

import com.aftersales.aftersalestools.dto.ticket.*;
import com.aftersales.aftersalestools.entity.Technician;
import com.aftersales.aftersalestools.entity.Vehicle;
import com.aftersales.aftersalestools.entity.ticket.Ticket;
import com.aftersales.aftersalestools.entity.ticket.TicketHistory;
import com.aftersales.aftersalestools.entity.ticket.TicketStatus;
import com.aftersales.aftersalestools.exception.ResourceNotFoundException;
import com.aftersales.aftersalestools.mapper.TicketMapper;
import com.aftersales.aftersalestools.repository.TechnicianRepository;
import com.aftersales.aftersalestools.repository.TicketHistoryRepository;
import com.aftersales.aftersalestools.repository.TicketRepository;
import com.aftersales.aftersalestools.repository.VehicleRepository;
import com.aftersales.aftersalestools.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketHistoryRepository ticketHistoryRepository;
    private final TechnicianRepository technicianRepository;

    @Override
    public TicketResponse create(TicketRequest request) {

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setCategory(request.getCategory());
        ticket.setDescription(request.getDescription());
        ticket.setDamageCategory(request.getDamageCategory());
        ticket.setDamagedPart(request.getDamagedPart());
        ticket.setComplaintDate(request.getComplaintDate());
        ticket.setOdometer(request.getOdometer());
        ticket.setPicName(request.getPicName());
        ticket.setPicPhone(request.getPicPhone());

        return TicketMapper.toResponse(ticketRepository.save(ticket));
    }

    @Override
    public List<TicketResponse> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::toResponse)
                .toList();
    }


    @Override
    @Transactional
    public TicketResponse updateStatus(Long ticketId, TicketStatusUpdateRequest request) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        TicketStatus fromStatus = ticket.getStatus();
        TicketStatus toStatus = request.getToStatus();

        validateStatusFlow(fromStatus, toStatus);

        ticket.setStatus(toStatus);

        TicketHistory history = new TicketHistory();
        history.setTicket(ticket);
        history.setFromStatus(fromStatus);
        history.setToStatus(toStatus);
        history.setNote(request.getNote());
        history.setChangedBy("SYSTEM");

        ticketHistoryRepository.save(history);

        return TicketMapper.toResponse(ticket);
    }

    private void validateStatusFlow(TicketStatus from, TicketStatus to) {
        if (from == TicketStatus.OPEN && to != TicketStatus.IN_PROGRESS) {
            throw new IllegalStateException("OPEN hanya bisa ke IN_PROGRESS");
        }
        if (from == TicketStatus.IN_PROGRESS && to != TicketStatus.RESOLVED) {
            throw new IllegalStateException("IN_PROGRESS hanya bisa ke RESOLVED");
        }
        if (from == TicketStatus.RESOLVED && to != TicketStatus.CLOSED) {
            throw new IllegalStateException("RESOLVED hanya bisa ke CLOSED");
        }
    }


    @Override
    public TicketDetailResponse findDetail(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<TicketHistoryResponse> histories =
                ticketHistoryRepository
                        .findByTicketIdOrderByChangedAtAsc(ticketId)
                        .stream()
                        .map(TicketMapper::toHistoryResponse)
                        .toList();

        TicketDetailResponse res = new TicketDetailResponse();
        res.setTicket(TicketMapper.toResponse(ticket));
        res.setHistories(histories);

        return res;
    }

    @Override
    @Transactional
    public TicketResponse assignTechnician(
            Long ticketId,
            TicketAssignRequest request) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        Technician technician = technicianRepository.findById(request.getTechnicianId())
                .orElseThrow(() -> new ResourceNotFoundException("Technician not found"));

        ticket.setTechnician(technician);
        ticket.setSlaStartAt(LocalDateTime.now());
        ticket.setSlaDueAt(request.getSlaDueAt());

        // otomatis pindah status
        ticket.setStatus(TicketStatus.IN_PROGRESS);

        return TicketMapper.toResponse(ticket);
    }


}
