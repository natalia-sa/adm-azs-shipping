package com.azship.azship.controllers.freight;

import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freight")
public class FreightController {


    @PostMapping(value = "")
    @Operation(summary = "Save new freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Freight was saved successfully")})
    public ResponseEntity<CustomerFreight> save(
            @RequestBody
            @Valid
            CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto
    ) throws JsonProcessingException {
        // tirar constraint de que customer so tem um freight type
        // Mudar a anotação oneToOne
        // finalizar esse crud
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
