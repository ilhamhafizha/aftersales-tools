package com.aftersales.aftersalestools.entity.ticket;

public class TicketNumberGenerator {

    public static String generate() {
        return "TCK-" + System.currentTimeMillis();
    }
}

