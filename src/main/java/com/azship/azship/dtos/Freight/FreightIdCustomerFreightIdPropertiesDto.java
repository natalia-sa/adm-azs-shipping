package com.azship.azship.dtos.Freight;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FreightIdCustomerFreightIdPropertiesDto(
        @Schema(example = "1", description = "The id of the freight to be updated")
        @NotNull
        Long freightId,

        @Schema(example = "1", description = "The new customer freight id")
        @NotNull
        Long customerFreightId,

        @Schema(example = "1", description = "The new properties")
        JsonNode properties) {
}
