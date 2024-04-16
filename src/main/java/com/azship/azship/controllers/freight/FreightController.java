package com.azship.azship.controllers.freight;

import com.azship.azship.dtos.Freight.FreightDto;
import com.azship.azship.dtos.Freight.FreightIdCustomerFreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightIdPropertiesDto;
import com.azship.azship.dtos.Freight.FreightPropertyNamePropertyValuePaginationDto;
import com.azship.azship.dtos.basic.PaginationDto;
import com.azship.azship.services.freight.FreightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/freight")
public class FreightController {

    @Autowired
    private FreightService freightService;


    @PostMapping(value = "")
    @Operation(summary = "Save new freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Freight was saved successfully")})
    public ResponseEntity<Long> save(
            @RequestBody
            @Valid
            FreightDto freightDto
    ) throws JsonProcessingException {
        Long freightId = freightService.save(freightDto);
        return new ResponseEntity<>(freightId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "")
    @Operation(summary = "Delete freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Freight was deleted successfully")})
    public ResponseEntity<Void> delete(
            @RequestParam
            @NotBlank
            @Schema(example = "1")
            Long id
    ) {
        freightService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "")
    @Operation(summary = "Update freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Freight was updated successfully")})
    public ResponseEntity<Long> update(
            @RequestBody
            @Valid
            FreightIdCustomerFreightIdPropertiesDto freightDto
    ) throws JsonProcessingException {
        freightService.update(freightDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/by/property/pagination")
    @Operation(summary = "List freights paginated filtering by the specified property")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Freights found")})
    public ResponseEntity<Collection<FreightIdPropertiesDto>> findByPagination(
            @RequestParam(required = false)
            @Schema(example = "weight")
            String propertyName,

            @RequestParam(required = false)
            @Schema(example = "3")
            Object propertyValue,

            @RequestParam
            @Schema(example = "1")
            @NotNull
            Integer page,

            @RequestParam
            @Schema(example = "10")
            @NotNull
            Integer size
    ) throws JsonProcessingException {
        PaginationDto paginationDto = new PaginationDto(page, size);
        FreightPropertyNamePropertyValuePaginationDto dto = new FreightPropertyNamePropertyValuePaginationDto(propertyName, propertyValue, paginationDto);
        List<FreightIdPropertiesDto> response = freightService.findByPropertyAndPagination(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
