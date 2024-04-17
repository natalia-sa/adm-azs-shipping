package com.azship.azship.controllers.customer;

import com.azship.azship.dtos.basic.IdDto;
import com.azship.azship.dtos.customer.CustomerNameCnpjDto;
import com.azship.azship.models.customer.Customer;
import com.azship.azship.services.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "")
    @Operation(summary = "Save new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The id of the saved customer")})
    public ResponseEntity<IdDto> save(
            @RequestBody
            @Valid
            CustomerNameCnpjDto customerDto
    ) {
        Long customerId = customerService.save(customerDto).getId();
        IdDto idDto = new IdDto(customerId);
        return new ResponseEntity<>(idDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was deleted successfully")})
    public ResponseEntity<Void> delete(
            @RequestParam
            @NotBlank
            @Schema(example = "1")
            Long id
    ) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    @Operation(summary = "List all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customers found",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Customer.class))) })})
    public ResponseEntity<Collection<Customer>> findAll() {
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
