package com.spring.rest.apiresponse;


import com.spring.rest.model.DeploymentConfiguration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class DeploymentConfigurationResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<DeploymentConfiguration> response;

    public DeploymentConfigurationResponse(ApiResponseLocal<DeploymentConfiguration> response) {
        this.response = response;
    }

    public ApiResponseLocal<DeploymentConfiguration> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<DeploymentConfiguration> response) {
        this.response = response;
    }
}
