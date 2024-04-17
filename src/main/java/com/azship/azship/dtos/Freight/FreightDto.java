package com.azship.azship.dtos.Freight;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FreightDto(
        @Schema(example = "1", description = "The customer freight id")
        @NotNull
        Long customerFreight,

        @Schema(example = "{\"weight\": 1, \"quantity\": 2}", description = "The values to the customer freight properties")
        JsonNode properties) {
}
