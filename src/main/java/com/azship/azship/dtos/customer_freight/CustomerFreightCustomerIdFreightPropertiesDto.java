package com.azship.azship.dtos.customer_freight;

import com.fasterxml.jackson.databind.JsonNode;

public record CustomerFreightCustomerIdFreightPropertiesDto(Long customerId, JsonNode freightProperties) {
}
