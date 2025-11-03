package com.spring.rest.apiresponse;


import com.spring.rest.model.PublishRest;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class PublishRestResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<PublishRest> response;

    public PublishRestResponse(ApiResponseLocal<PublishRest> response) {
        this.response = response;
    }

    public ApiResponseLocal<PublishRest> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<PublishRest> response) {
        this.response = response;
    }
}
