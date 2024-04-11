package com.azship.azship;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freight")
public class FreightApiController {

    @PostMapping(value = "")
    @Operation(summary = "Save new freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Freight was saved successfully")})
    public ResponseEntity save() {
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    @Operation(summary = "Update freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Freight was updated successfully")})
    public ResponseEntity update() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Freight was deleted successfully")})
    public ResponseEntity delete() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "")
    @Operation(summary = "List freights")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The freights found")})
    public ResponseEntity findByPagination() {
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

}
