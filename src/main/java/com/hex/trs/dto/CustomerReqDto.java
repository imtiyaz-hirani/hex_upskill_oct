package com.hex.trs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerReqDto(
        @NotBlank
        @NotNull
        String name,
        @NotBlank
        @NotNull
        String city,
        @NotBlank
        @NotNull
        String autoCode
) {
}
