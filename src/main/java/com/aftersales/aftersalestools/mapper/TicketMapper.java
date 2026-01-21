package com.aftersales.aftersalestools.mapper;

import com.aftersales.aftersalestools.dto.ticket.TicketResponse;

import com.aftersales.aftersalestools.entity.Vehicle;
import com.aftersales.aftersalestools.entity.ticket.Ticket;

public class TicketMapper {

    public static TicketResponse toResponse(Ticket ticket) {
        TicketResponse res = new TicketResponse();

        res.setId(ticket.getId());
        res.setCategory(ticket.getCategory());
        res.setStatus(ticket.getStatus().name());
        res.setDescription(ticket.getDescription());
        res.setComplaintDate(ticket.getComplaintDate());
        res.setResolvedDate(ticket.getResolvedDate());
        res.setOdometer(ticket.getOdometer());
        res.setCreatedAt(ticket.getCreatedAt());

        Vehicle vehicle = ticket.getVehicle();

        // 🔹 Vehicle
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

        return res;
    }
}
