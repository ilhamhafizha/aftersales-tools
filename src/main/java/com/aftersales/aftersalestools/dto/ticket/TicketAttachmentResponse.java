package com.aftersales.aftersalestools.dto.ticket;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketAttachmentResponse {
    private Long id;
    private String fileName;
    private String fileUrl;
    private String fileType;
    private LocalDateTime uploadedAt;
}
