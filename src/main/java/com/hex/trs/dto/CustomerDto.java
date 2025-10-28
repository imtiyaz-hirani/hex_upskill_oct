package com.hex.trs.dto;

public record CustomerDto(
        long id,
        String customerName,
        long numberOfTickets
) { }
