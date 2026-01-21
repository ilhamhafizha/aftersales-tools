package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

@Data
public class TicketAttachmentRequest {
    private String fileName;
    private String fileUrl;
    private String fileType;
}
