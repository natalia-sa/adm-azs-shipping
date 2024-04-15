package com.azship.azship.controllers.customer_freight;

import com.azship.azship.dtos.customer_freight.CustomerFreightCustomerIdFreightPropertiesDto;
import com.azship.azship.models.customer_freight.CustomerFreight;
import com.azship.azship.services.customer_freight.CustomerFreightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/freight")
public class CustomerFreightController {

    @Autowired
    private CustomerFreightService customerFreightService;

    @PostMapping(value = "")
    @Operation(summary = "Save new Customer freight, entity responsible for storing the freight information of each client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer freight was saved successfully")})
    public ResponseEntity<CustomerFreight> save(
            @RequestBody
            @Valid
            CustomerFreightCustomerIdFreightPropertiesDto customerFreightDto
    ) throws JsonProcessingException {
        CustomerFreight customerFreight = customerFreightService.save(customerFreightDto);
        return new ResponseEntity<>(customerFreight, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    @Operation(summary = "Update Customer freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer freight was updated successfully")})
    public ResponseEntity update() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete Customer freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer freight was deleted successfully")})
    public ResponseEntity<Void> delete() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    @Operation(summary = "List Customer freights")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer freights found")})
    public ResponseEntity<Collection<CustomerFreight>> findByPagination() {
        List<CustomerFreight> customerFreights = customerFreightService.findAll();
        return new ResponseEntity<>(customerFreights, HttpStatus.OK);
    }

}
