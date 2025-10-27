package com.hex.trs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TicketReqDto(
        @NotNull
        @NotBlank
        @Size(max = 255)
        String subject,
        @NotNull
        @NotBlank
        @Size(max = 1000)
        String issue,
        @NotNull
        @NotBlank
       String priority
) { }
