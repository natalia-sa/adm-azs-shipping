package com.azship.azship.controllers.customer;

import com.azship.azship.dtos.CustomerNameCnpjDto;
import com.azship.azship.models.Customer;
import com.azship.azship.services.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "")
    @Operation(summary = "Save new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer was saved successfully")})
    public ResponseEntity save(
            @RequestBody
            @Valid
            CustomerNameCnpjDto customerDto
    ) {
        customerService.save(customerDto);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    @Operation(summary = "Update customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was updated successfully")})
    public ResponseEntity update() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer was deleted successfully")})
    public ResponseEntity delete() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "")
    @Operation(summary = "List all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customers found")})
    public ResponseEntity findAll() {
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
