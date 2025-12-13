package com.spring.rest.apiresponse;


import com.spring.rest.model.ApiKey;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ApiKeyResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<ApiKey> response;

    public ApiKeyResponse(ApiResponseLocal<ApiKey> response) {
        this.response = response;
    }

    public ApiResponseLocal<ApiKey> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<ApiKey> response) {
        this.response = response;
    }
}
