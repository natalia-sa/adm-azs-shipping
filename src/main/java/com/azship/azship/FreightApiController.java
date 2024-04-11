package com.azship.azship;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freight")
public class FreightApiController {

    @PostMapping(value = "")
    @Operation(summary = "Save new freight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The saved freight")})
    public ResponseEntity save() {
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

}
