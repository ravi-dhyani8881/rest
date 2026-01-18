package com.spring.rest.custom;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import com.spring.rest.custom.*;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
    @ApiResponse(responseCode = "400", description = "Bad Request",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                value = "{\"code\": \"bad_request\", \"message\": \"Invalid request parameters.\"}"
            ),
            schema = @Schema(implementation = ErrorResponse.class)
        )
    ),
    @ApiResponse(responseCode = "401", description = "Unauthorized",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                value = "{\"code\": \"unauthorized\", \"message\": \"Missing or invalid API key.\"}"
            ),
            schema = @Schema(implementation = ErrorResponse.class)
        )
    ),
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                value = "{\"code\": \"internal_error\", \"message\": \"Unexpected error occurred.\"}"
            ),
            schema = @Schema(implementation = ErrorResponse.class)
        )
    ),
    @ApiResponse(responseCode = "503", description = "Service Unavailable",
        content = @Content(
            mediaType = "application/json",
            examples = @ExampleObject(
                value = "{\"code\": \"service_unavailable\", \"message\": \"Service temporarily unavailable.\"}"
            ),
            schema = @Schema(implementation = ErrorResponse.class)
        )
    )
})
public @interface StandardApiResponses {
}