package com.spring.rest.apiresponse;


import com.spring.rest.model.SubOrganization;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class SubOrganizationResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<SubOrganization> response;

    public SubOrganizationResponse(ApiResponseLocal<SubOrganization> response) {
        this.response = response;
    }

    public ApiResponseLocal<SubOrganization> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<SubOrganization> response) {
        this.response = response;
    }
}
