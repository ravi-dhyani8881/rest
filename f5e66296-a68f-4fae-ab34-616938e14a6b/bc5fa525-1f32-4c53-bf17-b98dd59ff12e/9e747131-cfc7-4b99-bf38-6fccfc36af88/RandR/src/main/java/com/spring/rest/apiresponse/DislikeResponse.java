package com.spring.rest.apiresponse;


import com.spring.rest.model.Dislike;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class DislikeResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Dislike> response;

    public DislikeResponse(ApiResponseLocal<Dislike> response) {
        this.response = response;
    }

    public ApiResponseLocal<Dislike> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Dislike> response) {
        this.response = response;
    }
}
