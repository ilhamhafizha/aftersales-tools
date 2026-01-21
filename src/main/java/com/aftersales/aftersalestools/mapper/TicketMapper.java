package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.ticket.TicketHistoryResponse;
import com.aftersales.aftersalestools.dto.ticket.TicketResponse;
import com.aftersales.aftersalestools.entity.Vehicle;
import com.aftersales.aftersalestools.entity.ticket.Ticket;
import com.aftersales.aftersalestools.entity.ticket.TicketHistory;

public class TicketMapper {

    public static TicketResponse toResponse(Ticket ticket) {

        TicketResponse res = new TicketResponse();

        // 🔹 Ticket
        res.setId(ticket.getId());
        res.setCategory(ticket.getCategory());
        res.setStatus(ticket.getStatus().name());
        res.setDescription(ticket.getDescription());
        res.setComplaintDate(ticket.getComplaintDate());
        res.setResolvedDate(ticket.getResolvedDate());
        res.setOdometer(ticket.getOdometer());
        res.setCreatedAt(ticket.getCreatedAt());

        // 🔹 Vehicle
        Vehicle vehicle = ticket.getVehicle();
        res.setVehicleId(vehicle.getId());
        res.setPlateNumber(vehicle.getPlateNumber());
        res.setBrand(vehicle.getBrand());
        res.setModel(vehicle.getModel());

        // 🔹 Customer & Location
        res.setCustomerName(vehicle.getCustomer().getName());
        res.setLocationName(
                vehicle.getCustomer()
                        .getLocation()
                        .getName()
        );

        // 🔹 Technician (OPTIONAL)
        if (ticket.getTechnician() != null) {
            res.setTechnicianId(ticket.getTechnician().getId());
            res.setTechnicianName(ticket.getTechnician().getName());
        }

        // 🔹 SLA
        res.setSlaStartAt(ticket.getSlaStartAt());
        res.setSlaDueAt(ticket.getSlaDueAt());
        res.setSlaResolvedAt(ticket.getSlaResolvedAt());

        return res;
    }

    public static TicketHistoryResponse toHistoryResponse(
            TicketHistory history) {

        TicketHistoryResponse res = new TicketHistoryResponse();
        res.setFromStatus(history.getFromStatus().name());
        res.setToStatus(history.getToStatus().name());
        res.setNote(history.getNote());
        res.setChangedBy(history.getChangedBy());
        res.setChangedAt(history.getChangedAt());

        return res;
    }
}
