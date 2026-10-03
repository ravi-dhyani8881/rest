package com.spring.rest.apiresponse;


import com.spring.rest.model.UserOrg;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class UserOrgResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<UserOrg> response;

    public UserOrgResponse(ApiResponseLocal<UserOrg> response) {
        this.response = response;
    }

    public ApiResponseLocal<UserOrg> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<UserOrg> response) {
        this.response = response;
    }
}
