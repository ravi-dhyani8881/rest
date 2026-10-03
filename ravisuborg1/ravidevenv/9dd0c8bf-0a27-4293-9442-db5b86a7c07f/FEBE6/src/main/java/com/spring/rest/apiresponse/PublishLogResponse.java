package com.spring.rest.apiresponse;


import com.spring.rest.model.PublishLog;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class PublishLogResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<PublishLog> response;

    public PublishLogResponse(ApiResponseLocal<PublishLog> response) {
        this.response = response;
    }

    public ApiResponseLocal<PublishLog> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<PublishLog> response) {
        this.response = response;
    }
}
