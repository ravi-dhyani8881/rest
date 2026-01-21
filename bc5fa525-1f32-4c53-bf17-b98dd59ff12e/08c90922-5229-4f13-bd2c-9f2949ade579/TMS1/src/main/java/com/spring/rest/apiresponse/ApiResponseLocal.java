package com.spring.rest.apiresponse;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Standard API response with data and pagination")
public record ApiResponseLocal<T>(
        @Schema(description = "List of data records")
        List<T> data,

        @Schema(description = "Pagination metadata")
        Pagination pagination
) {
    @Schema(description = "Pagination details")
    public record Pagination(
            @Schema(description = "Total number of records found")
            long total,

            @Schema(description = "Number of records returned per page")
            int limit,

            @Schema(description = "Starting offset for the current page")
            int offset
    ) {}
}