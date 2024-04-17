package com.azship.azship.dtos.customer_freight;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerFreightCustomerIdFreightPropertiesDto(
        @Schema(example = "1", description = "The customer id")
        @NotNull
        Long customerId,

        @Schema(example = "{\"weight\": \"INTEGER\", \"quantity\": \"INTEGER\"}", description = "The properties that must be filled out for the customer's freights. Pattern: \"propertyName\": \"propertyType\"")
        JsonNode freightProperties) {
}
