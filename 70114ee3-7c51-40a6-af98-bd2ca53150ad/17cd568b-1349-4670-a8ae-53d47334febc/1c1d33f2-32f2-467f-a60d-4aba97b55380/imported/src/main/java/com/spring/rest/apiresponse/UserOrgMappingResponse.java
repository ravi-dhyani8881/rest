package com.spring.rest.apiresponse;


import com.spring.rest.model.UserOrgMapping;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class UserOrgMappingResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<UserOrgMapping> response;

    public UserOrgMappingResponse(ApiResponseLocal<UserOrgMapping> response) {
        this.response = response;
    }

    public ApiResponseLocal<UserOrgMapping> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<UserOrgMapping> response) {
        this.response = response;
    }
}
