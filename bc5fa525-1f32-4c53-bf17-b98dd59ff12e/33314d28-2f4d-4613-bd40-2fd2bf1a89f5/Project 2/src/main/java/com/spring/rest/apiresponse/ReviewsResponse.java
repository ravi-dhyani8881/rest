package com.spring.rest.apiresponse;


import com.spring.rest.model.Reviews;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ReviewsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Reviews> response;

    public ReviewsResponse(ApiResponseLocal<Reviews> response) {
        this.response = response;
    }

    public ApiResponseLocal<Reviews> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Reviews> response) {
        this.response = response;
    }
}
