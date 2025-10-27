package com.hex.trs.dto;

public record TicketRespDto(
        Long id,
        String status,
        String createdAt
) {
}
