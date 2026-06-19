package com.spring.rest.apiresponse;


import com.spring.rest.model.Review;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ReviewResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Review> response;

    public ReviewResponse(ApiResponseLocal<Review> response) {
        this.response = response;
    }

    public ApiResponseLocal<Review> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Review> response) {
        this.response = response;
    }
}
