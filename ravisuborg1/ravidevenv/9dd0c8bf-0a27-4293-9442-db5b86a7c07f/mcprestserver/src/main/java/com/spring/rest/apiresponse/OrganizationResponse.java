package com.spring.rest.apiresponse;


import com.spring.rest.model.Organization;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class OrganizationResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Organization> response;

    public OrganizationResponse(ApiResponseLocal<Organization> response) {
        this.response = response;
    }

    public ApiResponseLocal<Organization> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Organization> response) {
        this.response = response;
    }
}
