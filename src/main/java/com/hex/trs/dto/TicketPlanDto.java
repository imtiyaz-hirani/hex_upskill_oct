package com.hex.trs.dto;

import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;

import java.time.Instant;
//flat dto : few things from many models
public record TicketPlanDto(
        long ticketId,
        Priority priority,
        Status status,
        Instant createdAt,
        String customerName,
        String executiveName,
        String jobTitle,
        String planName,
        double price
) {
}
