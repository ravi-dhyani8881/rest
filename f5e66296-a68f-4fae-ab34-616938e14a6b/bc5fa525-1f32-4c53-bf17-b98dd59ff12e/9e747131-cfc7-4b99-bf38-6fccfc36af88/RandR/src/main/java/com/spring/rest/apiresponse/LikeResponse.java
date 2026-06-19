package com.spring.rest.apiresponse;


import com.spring.rest.model.Like;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class LikeResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Like> response;

    public LikeResponse(ApiResponseLocal<Like> response) {
        this.response = response;
    }

    public ApiResponseLocal<Like> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Like> response) {
        this.response = response;
    }
}
