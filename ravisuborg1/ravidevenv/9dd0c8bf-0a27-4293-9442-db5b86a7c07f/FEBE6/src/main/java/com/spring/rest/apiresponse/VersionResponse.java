package com.spring.rest.apiresponse;


import com.spring.rest.model.Version;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class VersionResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Version> response;

    public VersionResponse(ApiResponseLocal<Version> response) {
        this.response = response;
    }

    public ApiResponseLocal<Version> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Version> response) {
        this.response = response;
    }
}
