package com.spring.rest.apiresponse;


import com.spring.rest.model.Deployment;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class DeploymentResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Deployment> response;

    public DeploymentResponse(ApiResponseLocal<Deployment> response) {
        this.response = response;
    }

    public ApiResponseLocal<Deployment> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Deployment> response) {
        this.response = response;
    }
}
