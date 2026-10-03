package com.spring.rest.apiresponse;


import com.spring.rest.model.Configuration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ConfigurationResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Configuration> response;

    public ConfigurationResponse(ApiResponseLocal<Configuration> response) {
        this.response = response;
    }

    public ApiResponseLocal<Configuration> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Configuration> response) {
        this.response = response;
    }
}
