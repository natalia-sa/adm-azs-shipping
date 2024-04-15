package com.azship.azship.dtos.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CustomerNameCnpjDto(
        @Schema(example = "Company1", description = "The customer name")
        @NotBlank
        String name,

        @Schema(example = "12356432345678", description = "The customer CNPJ")
        @NotBlank
        String cnpj) {
}
