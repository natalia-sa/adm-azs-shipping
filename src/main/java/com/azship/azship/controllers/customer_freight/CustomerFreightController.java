package com.azship.azship.controllers.customer_freight;

import com.azship.azship.dtos.basic.IdDto;
import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.dtos.customer_freight.CustomerIdFreightPropertiesDto;
import com.azship.azship.services.customer_freight.CustomerFreightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/customer-freight")
public class CustomerFreightController {

    @Autowired
    private CustomerFreightService customerFreightService;

    @PostMapping(value = "")
    @Operation(summary = "Save new Customer freight, entity responsible for storing the freight information of each client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The id of the saved customer freight",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = IdDto.class))})})
    public ResponseEntity<IdDto> save(
            @RequestBody
            @Valid
            CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto
    ) throws JsonProcessingException {
        Long customerFreightId = customerFreightService.save(customerFreightDto).getId();
        IdDto idDto = new IdDto(customerFreightId);
        return new ResponseEntity<>(idDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete Customer freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer freight was deleted successfully")})
    public ResponseEntity<Void> delete(
            @RequestParam
            @NotNull
            @Schema(example = "1")
            Long id
    ) {
        customerFreightService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    @Operation(summary = "List all customer freights")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer freights found",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CustomerIdFreightPropertiesDto.class))) })})
    public ResponseEntity<Collection<CustomerIdFreightPropertiesDto>> findByPagination() {
        List<CustomerIdFreightPropertiesDto> customerFreights = customerFreightService.findCustomerIdAndFreightProperties();
        return new ResponseEntity<>(customerFreights, HttpStatus.OK);
    }

}
